package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.DisciplinaDTO;
import br.com.mirante.eduapi.dto.MaterialComplementarDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Disciplina;
import br.com.mirante.eduapi.models.MaterialComplementar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface MaterialComplementarService {
    Page<MaterialComplementar> findAll(Specification<MaterialComplementar> spec, Pageable page);

    MaterialComplementarDTO save(MaterialComplementarDTO materialComplementarDTO) throws BusinessException;

    Optional<MaterialComplementarDTO> findById(UUID id);

    Optional<MaterialComplementarDTO> update(UUID id, MaterialComplementarDTO materialComplementarDTO);

    boolean delete(UUID id);
}
