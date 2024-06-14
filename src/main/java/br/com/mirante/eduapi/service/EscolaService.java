package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.EscolaDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Escola;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface EscolaService {
    Page<Escola> findAll(Specification<Escola> spec, Pageable page);

    EscolaDTO save(EscolaDTO escolaDTO) throws BusinessException;

    Optional<EscolaDTO> findById(UUID id);

    Optional<EscolaDTO> update(UUID id, EscolaDTO escolaDTO);

    boolean deleteById(UUID id);
}
