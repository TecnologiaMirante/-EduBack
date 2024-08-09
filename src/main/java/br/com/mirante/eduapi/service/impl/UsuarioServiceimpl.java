package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.client.AuthClient;
import br.com.mirante.eduapi.dto.CredentialDTO;
import br.com.mirante.eduapi.dto.UserDTO;
import br.com.mirante.eduapi.dto.UsuarioDTO;
import br.com.mirante.eduapi.dto.UsuarioDTOPost;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.UsuarioMapper;
import br.com.mirante.eduapi.models.Usuario;
import br.com.mirante.eduapi.repository.UsuarioRepository;
import br.com.mirante.eduapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class UsuarioServiceimpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuthClient authClient;

    @Override
    public Page<Usuario> findAll(Specification<Usuario> spec, Pageable page) {
        return usuarioRepository.findAll(spec, page);
    }

    @Override
    public UsuarioDTOPost save(UsuarioDTOPost usuarioDTO) throws BusinessException {
        Usuario usuario = UsuarioMapper.INSTANCE.usuarioDTOPostToUsuario(usuarioDTO);

       if (usuarioRepository.findByEmail(usuarioDTO.getEmail()) != null) {
            throw new BusinessException("Usuario Ja existe com este email");
        }

       UserDTO userDTO = new UserDTO();
       userDTO.setUsername(usuarioDTO.getUsername());
       userDTO.setEnabled(true);
       userDTO.setFirstName(usuarioDTO.getNome());
       userDTO.setLastName(usuarioDTO.getNome());
       userDTO.setEmail(usuarioDTO.getEmail());

        CredentialDTO credentialDTO = new CredentialDTO();
        credentialDTO.setType("password");
        credentialDTO.setValue(usuarioDTO.getSenha());
        credentialDTO.setTemporary(false);

       List<CredentialDTO> credentialDTOList = new ArrayList<>();
       credentialDTOList.add(credentialDTO);
       userDTO.setCredentials(credentialDTOList);

        ResponseEntity<Void> response = authClient.cadastrarUsuario(userDTO);

        String locationHeader = response.getHeaders().getFirst("Location");

        String idUsuarioKeyCloack = null;
        if (locationHeader != null && !locationHeader.isEmpty()) {
            idUsuarioKeyCloack = locationHeader.substring(locationHeader.lastIndexOf('/') + 1);
        } else {
            throw new RuntimeException("O cabeçalho 'Location' não foi encontrado na resposta.");
        }

        usuario.setIdKeycloak(idUsuarioKeyCloack);
        usuario = usuarioRepository.save(usuario);

        return UsuarioMapper.INSTANCE.usuarioToUsuarioDTOPost(usuario);
    }

    @Override
    public Optional<UsuarioDTO> findById(UUID id) {
        return usuarioRepository.findById(id).map(UsuarioMapper.INSTANCE::usuarioToUsuarioDTO);
    }

    @Override
    public Optional<UsuarioDTO> update(UUID id, UsuarioDTO usuarioDTO) {
        if (usuarioRepository.existsById(id)) {
            Usuario usuario = UsuarioMapper.INSTANCE.usuarioDTOToUsuario(usuarioDTO);
            usuario.setId(id);
            usuario = usuarioRepository.save(usuario);
            return Optional.of(UsuarioMapper.INSTANCE.usuarioToUsuarioDTO(usuario));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID id) {
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
