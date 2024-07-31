package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.TurmaDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Turma;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface TurmaService {
    Page<Turma> findAll(Specification<Turma> spec, Pageable page);

    TurmaDTO save(TurmaDTO turmaDTO) throws BusinessException;

    Optional<TurmaDTO> findById(UUID id);

    Optional<TurmaDTO> update(UUID id, TurmaDTO turmaDTO);

    boolean delete(UUID id);
}
