package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.EloDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Elo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface EloService {
    Page<Elo> findAll(Specification<Elo> spec, Pageable page);

    EloDTO  save(EloDTO eloDTO) throws BusinessException;

    Optional<EloDTO> findById(UUID id);

    Optional<EloDTO> update(UUID id, EloDTO eloDTO);

    boolean deleteById(UUID id);
}
