package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.ConteudoDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Conteudo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface ConteudoService {
    Page<Conteudo> findAll(Specification<Conteudo> spec, Pageable page);

    ConteudoDTO save(ConteudoDTO conteudoDTO) throws BusinessException;

    Optional<ConteudoDTO> findById(UUID id);

    Optional<ConteudoDTO> update(UUID id, ConteudoDTO conteudoDTO);

    boolean delete(UUID id);
}

