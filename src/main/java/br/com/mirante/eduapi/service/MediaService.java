package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.EscolaDTO;
import br.com.mirante.eduapi.dto.MediaDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Escola;
import br.com.mirante.eduapi.models.Media;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface MediaService {
    Page<Media> findAll(Specification<Media> spec, Pageable page);

    MediaDTO save(MediaDTO mediaDTO) throws BusinessException;

    Optional<MediaDTO> findById(UUID id);

    Optional<MediaDTO> update(UUID id, MediaDTO mediaDTO);

    boolean delete(UUID id);
}
