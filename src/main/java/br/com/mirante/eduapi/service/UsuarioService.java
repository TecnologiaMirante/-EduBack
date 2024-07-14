package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.UsuarioDTO;
import br.com.mirante.eduapi.dto.UsuarioDTOPost;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioService {

    Page<Usuario> findAll(Specification<Usuario> spec, Pageable page);

    UsuarioDTOPost save(UsuarioDTOPost usuarioDTO) throws BusinessException;

    Optional<UsuarioDTO> findById(UUID id);

    Optional<UsuarioDTO> update(UUID id, UsuarioDTO usuarioDTO);

    boolean delete(UUID id) ;

}
