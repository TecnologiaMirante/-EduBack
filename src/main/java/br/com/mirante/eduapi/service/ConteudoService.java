package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.ConteudoDTO;
import br.com.mirante.eduapi.dto.ConteudoDTOpost;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Conteudo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface ConteudoService {
    Page<Conteudo> findAll(Specification<Conteudo> spec, Pageable page);

    ConteudoDTOpost save(ConteudoDTOpost conteudoDTOpost) throws BusinessException;

    Optional<ConteudoDTO> findById(UUID id);

    Optional<ConteudoDTOpost> update(UUID id, ConteudoDTOpost conteudoDTOpost);

    boolean delete(UUID id);
}

