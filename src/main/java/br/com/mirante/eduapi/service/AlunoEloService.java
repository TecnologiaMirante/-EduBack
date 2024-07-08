package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.AdminDTO;
import br.com.mirante.eduapi.dto.AlunosEloDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Admin;
import br.com.mirante.eduapi.models.AlunosElo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface AlunoEloService {

    Page<AlunosElo> findAll(Specification<AlunosElo> spec, Pageable page);

    AlunosEloDTO save(AlunosEloDTO alunosEloDTO) throws BusinessException;

    Optional<AlunosEloDTO> findById(UUID id);

    Optional<AlunosEloDTO> update(UUID id, AlunosEloDTO alunosEloDTO);

    boolean deleteById(UUID id);
}
