package br.com.mirante.eduapi.service.impl;

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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioServiceimpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Page<Usuario> findAll(Specification<Usuario> spec, Pageable page) {
        Page<Usuario> usuarios = usuarioRepository.findAll(spec, page);

        return usuarios;
    }

    @Override
    public UsuarioDTOPost save(UsuarioDTOPost usuarioDTO) throws BusinessException {
        Usuario usuario = UsuarioMapper.INSTANCE.usuarioDTOPostToUsuario(usuarioDTO);

        if (usuarioRepository.findByMatricula(usuarioDTO.getMatricula()) != null){
            throw new BusinessException("Usuario Ja existe com essa matricula");
        } else if (usuarioRepository.findByCpf(usuarioDTO.getCpf()) != null) {
            throw new BusinessException("Usuario Ja existe com este cpf");
        } else if (usuarioRepository.findByEmail(usuarioDTO.getEmail()) != null) {
            throw new BusinessException("Usuario Ja existe com este email");
        }

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
