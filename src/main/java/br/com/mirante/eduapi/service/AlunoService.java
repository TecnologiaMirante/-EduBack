package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.AlunoDTO;
import br.com.mirante.eduapi.dto.AlunoDTOPost;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface AlunoService {

    Page<Aluno> findAll(Specification<Aluno> spec, Pageable page);

    AlunoDTOPost save(AlunoDTOPost aluno) throws BusinessException;

    Optional<AlunoDTO> findById(UUID id);

    Optional<AlunoDTO> update(UUID id, AlunoDTO aluno);

    boolean deleteById(UUID id);

}
