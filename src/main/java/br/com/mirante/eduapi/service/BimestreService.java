package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.BimestreDTO;
import br.com.mirante.eduapi.dto.BimestreDTOpost;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Bimestre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface BimestreService {
    Page<Bimestre> findAll(Specification<Bimestre> spec, Pageable page);

    BimestreDTOpost save(BimestreDTOpost bimestreDTOpost) throws BusinessException;

    Optional<BimestreDTO> findById(UUID id);

    Optional<BimestreDTO> update(UUID id, BimestreDTO bimestreDTO);

    boolean delete(UUID id);
}
