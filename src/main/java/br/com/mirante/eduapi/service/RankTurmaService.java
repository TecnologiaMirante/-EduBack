package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.RankGeralDTO;
import br.com.mirante.eduapi.dto.RankTurmaDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.RankGeral;
import br.com.mirante.eduapi.models.RankTurma;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface RankTurmaService {
    Page<RankTurma> findAll(Specification<RankTurma> spec, Pageable page);

    RankTurmaDTO save(RankTurmaDTO rankTurmaDTO) throws BusinessException;

    Optional<RankTurmaDTO> findById(UUID id);

    Optional<RankTurmaDTO> update(UUID id, RankTurmaDTO rankTurmaDTO);

    boolean deleteById(UUID id);
}
