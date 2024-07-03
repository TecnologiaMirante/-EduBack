package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.UsuarioResponsavelDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.UsuarioMapper;
import br.com.mirante.eduapi.mappers.UsuarioResponsavelMapper;
import br.com.mirante.eduapi.models.UsuarioResponsavel;
import br.com.mirante.eduapi.repository.UsuarioResponsavelRepository;
import br.com.mirante.eduapi.service.UsuarioResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioResponsavelServiceImpl implements UsuarioResponsavelService {

    @Autowired
    private UsuarioResponsavelRepository usuarioResponsavelRepository;

    @Override
    public Page<UsuarioResponsavel> findAll(Specification<UsuarioResponsavel> spec, Pageable pageable) {
        return usuarioResponsavelRepository.findAll(spec, pageable);
    }

    @Override
    public UsuarioResponsavelDTO save(UsuarioResponsavelDTO usuarioResponsavelDTO) throws BusinessException {
        UsuarioResponsavel usuarioResponsavel = UsuarioResponsavelMapper.INSTANCE
                .usuarioResponsavelDTOToUsuarioResponsavel(usuarioResponsavelDTO);
        if (usuarioResponsavelRepository.findByCpf(usuarioResponsavel.getCpf()) != null){
            throw new BusinessException("O usuario responsavel ja existe com este cpf");
        }
       usuarioResponsavel = usuarioResponsavelRepository.save(usuarioResponsavel);

        return UsuarioResponsavelMapper.INSTANCE.usuarioResponsavelToUsuarioResponsavelDTO(usuarioResponsavel);
    }

    @Override
    public Optional<UsuarioResponsavelDTO> findById(UUID id) {


        return usuarioResponsavelRepository.findById(id)
                .map(UsuarioResponsavelMapper.INSTANCE::usuarioResponsavelToUsuarioResponsavelDTO);
    }

    @Override
    public Optional<UsuarioResponsavelDTO> update(UUID id, UsuarioResponsavelDTO usuarioResponsavelDTO) {
        if (usuarioResponsavelRepository.existsById(id)){
            UsuarioResponsavel usuarioResponsavel = UsuarioResponsavelMapper.INSTANCE.usuarioResponsavelDTOToUsuarioResponsavel(usuarioResponsavelDTO);
            usuarioResponsavel.setId(id);

            usuarioResponsavel = usuarioResponsavelRepository.save(usuarioResponsavel);

            return Optional.of(UsuarioResponsavelMapper.INSTANCE.usuarioResponsavelToUsuarioResponsavelDTO(usuarioResponsavel));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (usuarioResponsavelRepository.existsById(id)) {
            usuarioResponsavelRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
