package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.AlunoInteracaoDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.AlunoInteracaoMapper;
import br.com.mirante.eduapi.models.AlunoInteracao;
import br.com.mirante.eduapi.repository.AlunoInteracaoRepository;
import br.com.mirante.eduapi.service.AlunoInteracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AlunoInteracaoServiceImpl implements AlunoInteracaoService {

    @Autowired
    private AlunoInteracaoRepository alunoInteracaoRepository;

    @Override
    public Page<AlunoInteracao> findAll(Specification<AlunoInteracao> spec, Pageable page) {
        return alunoInteracaoRepository.findAll(spec, page);
    }

    @Override
    public AlunoInteracaoDTO save(AlunoInteracaoDTO alunoInteracaoDTO) throws BusinessException {
        AlunoInteracao alunoInteracao = AlunoInteracaoMapper.INSTANCE.alunoInteracaoDTOToAlunoInteracao(alunoInteracaoDTO);

        alunoInteracao = alunoInteracaoRepository.save(alunoInteracao);

        return AlunoInteracaoMapper.INSTANCE.alunoInteracaoToAlunoInteracaoDTO(alunoInteracao);
    }

    @Override
    public Optional<AlunoInteracaoDTO> findById(UUID id) {
        return alunoInteracaoRepository.findById(id)
                .map(AlunoInteracaoMapper.INSTANCE::alunoInteracaoToAlunoInteracaoDTO);
    }

    @Override
    public Optional<AlunoInteracaoDTO> update(UUID id, AlunoInteracaoDTO alunoInteracaoDTO) {

        if (alunoInteracaoRepository.existsById(id)) {
            AlunoInteracao alunoInteracao = AlunoInteracaoMapper.INSTANCE.alunoInteracaoDTOToAlunoInteracao(alunoInteracaoDTO);
            alunoInteracao.setId(id);
            alunoInteracaoRepository.save(alunoInteracao);

            return Optional.of(AlunoInteracaoMapper.INSTANCE.alunoInteracaoToAlunoInteracaoDTO(alunoInteracao));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (alunoInteracaoRepository.existsById(id)){
            alunoInteracaoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
