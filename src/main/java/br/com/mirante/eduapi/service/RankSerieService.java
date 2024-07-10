package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.RankGeralDTO;
import br.com.mirante.eduapi.dto.RankSerieDTO;
import br.com.mirante.eduapi.dto.RankTurmaDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.RankGeral;
import br.com.mirante.eduapi.models.RankSerie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface RankSerieService {
    Page<RankSerie> findAll(Specification<RankSerie> spec, Pageable page);

    Optional<RankSerieDTO> findById(UUID id);

    RankSerieDTO save(RankSerieDTO rankSerieDTO) throws BusinessException;

    Optional<RankSerieDTO> update(UUID id, RankSerieDTO rankSerieDTO);

    boolean deleteById(UUID id);
}
