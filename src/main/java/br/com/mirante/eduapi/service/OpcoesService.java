package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.OpcoesDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Opcoes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface OpcoesService {
    Page<Opcoes> findAll(Specification<Opcoes> spec, Pageable page);

    OpcoesDTO save(OpcoesDTO opcoesDTO) throws BusinessException;

    Optional<OpcoesDTO> findById(UUID id);

    Optional<OpcoesDTO> update(UUID id, OpcoesDTO opcoesDTO);

    boolean deleteById(UUID id);

}
