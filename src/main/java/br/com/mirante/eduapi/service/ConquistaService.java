package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.ConquistasDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Conquistas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface ConquistaService {
    Page<Conquistas> findAll(Specification<Conquistas> spec, Pageable page);

    ConquistasDTO save(ConquistasDTO conquistasDTO) throws BusinessException;

    Optional<ConquistasDTO> findById(UUID id);

    Optional<ConquistasDTO> update(UUID id, ConquistasDTO conquistasDTO);

    boolean deleteById(UUID id);
}
