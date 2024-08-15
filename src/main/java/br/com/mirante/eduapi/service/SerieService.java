package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.SerieDTO;
import br.com.mirante.eduapi.dto.SerieDTOpost;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Serie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;


public interface SerieService {
    Page<Serie> findAll(Specification<Serie>spec, Pageable pageable);

    SerieDTOpost save(SerieDTOpost serieDTOpost) throws BusinessException;

    Optional<SerieDTO> findById(UUID id);

    Optional<SerieDTOpost> update(UUID id, SerieDTOpost serieDTOpost);

    boolean delete(UUID id);


}
