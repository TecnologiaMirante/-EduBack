package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.ProfessorDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Professor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface ProfessorService {
    Page<Professor> findAll(Specification<Professor>spec, Pageable pageable);

    ProfessorDTO save(ProfessorDTO professorDTO) throws BusinessException;

    Optional<ProfessorDTO> findById(UUID id);

    Optional<ProfessorDTO> update(UUID id, ProfessorDTO professorDTO);

    boolean delete(UUID id);
}
