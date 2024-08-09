package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.UsuarioResponsavelDTO;
import br.com.mirante.eduapi.dto.UsuarioResponsavelDTOPost;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.UsuarioResponsavel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioResponsavelService {
    Page<UsuarioResponsavel> findAll(Specification<UsuarioResponsavel> spec, Pageable page);

    UsuarioResponsavelDTOPost save(UsuarioResponsavelDTOPost usuarioResponsavelDTO) throws BusinessException;

    Optional<UsuarioResponsavelDTO> findById(UUID id);

    Optional<UsuarioResponsavelDTO> update(UUID id, UsuarioResponsavelDTO usuarioResponsavelDTO);

    boolean deleteById(UUID id);

}
