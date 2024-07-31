package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.SerieDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Serie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;


public interface SerieService {
    Page<Serie> findAll(Specification<Serie>spec, Pageable pageable);

    SerieDTO save(SerieDTO serieDTO) throws BusinessException;

    Optional<SerieDTO> findById(UUID id);

    Optional<SerieDTO> update(UUID id, SerieDTO serieDTO);

    boolean delete(UUID id);


}
