package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.QuestoesDTO;
import br.com.mirante.eduapi.dto.RankGeralDTO;
import br.com.mirante.eduapi.dto.RankTurmaDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Questoes;
import br.com.mirante.eduapi.models.RankGeral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface RankGeralService {
    Page<RankGeral> findAll(Specification<RankGeral> spec, Pageable page);

    RankGeralDTO save(RankGeralDTO rankGeralDTO) throws BusinessException;

    Optional<RankGeralDTO> findById(UUID id);

    Optional<RankGeralDTO> update(UUID id, RankGeralDTO rankGeralDTO);

    boolean deleteById(UUID id);
}
