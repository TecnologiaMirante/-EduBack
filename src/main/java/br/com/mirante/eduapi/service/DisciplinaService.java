package br.com.mirante.eduapi.service;
import br.com.mirante.eduapi.dto.DisciplinaDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Disciplina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface DisciplinaService {
    Page<Disciplina> findAll(Specification<Disciplina> spec, Pageable page);

    DisciplinaDTO save(DisciplinaDTO disciplinaDTO) throws BusinessException;

    Optional<DisciplinaDTO> findById(UUID id);

    Optional<DisciplinaDTO> update(UUID id, DisciplinaDTO disciplinaDTO);

    boolean delete(UUID id);
}
