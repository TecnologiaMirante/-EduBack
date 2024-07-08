package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.AulaDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Aula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface AulaService {
    Page<Aula>  findAll(Specification<Aula> spec, Pageable page);

    AulaDTO save(AulaDTO aulaDTO) throws BusinessException;

    Optional<AulaDTO> findById(UUID id);

    Optional<AulaDTO> update(UUID id, AulaDTO aulaDTO);

    boolean deleteById(UUID id);

}
