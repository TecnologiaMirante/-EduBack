package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.RankAlunoDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.RankAluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface RankAlunoService {
    Page<RankAluno> findAll(Specification<RankAluno> spec, Pageable page);

    RankAlunoDTO save(RankAlunoDTO rankAlunoDTO) throws BusinessException;

    Optional<RankAlunoDTO> findById(UUID id);

    Optional<RankAlunoDTO> update(UUID id, RankAlunoDTO rankAlunoDTO);

    boolean deleteById(UUID id);
}
