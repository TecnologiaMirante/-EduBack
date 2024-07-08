package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.QuestoesDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Questoes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface QuestoesService {
    Page<Questoes> findAll(Specification<Questoes> spec, Pageable page);

    QuestoesDTO save(QuestoesDTO questoesDTO) throws BusinessException;

    Optional<QuestoesDTO> findById(UUID id);

    Optional<QuestoesDTO> update(UUID id, QuestoesDTO questoesDTO);

    boolean deleteById(UUID id);

}
