package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.dto.AlunoDTO;
import br.com.mirante.eduapi.dto.AlunoInteracaoDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.models.Aluno;
import br.com.mirante.eduapi.models.AlunoInteracao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public interface AlunoInteracaoService {
    Page<AlunoInteracao> findAll(Specification<AlunoInteracao> spec, Pageable page);

    AlunoInteracaoDTO save(AlunoInteracaoDTO alunoInteracaoDTO) throws BusinessException;

    Optional<AlunoInteracaoDTO> findById(UUID id);

    Optional<AlunoInteracaoDTO> update(UUID id, AlunoInteracaoDTO alunoInteracaoDTO);

    boolean deleteById(UUID id);
}
