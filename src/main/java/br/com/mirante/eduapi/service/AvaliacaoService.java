package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.AvaliacaoDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Avaliacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface AvaliacaoService {
    Page<Avaliacao> findAll(Specification<Avaliacao> spec, Pageable page);

    AvaliacaoDTO save(AvaliacaoDTO avaliacaoDTO) throws BusinessException;

    Optional<AvaliacaoDTO> findById(UUID id);

    Optional<AvaliacaoDTO> update(UUID id, AvaliacaoDTO avaliacaoDTO);

    boolean delete(UUID id);
}
