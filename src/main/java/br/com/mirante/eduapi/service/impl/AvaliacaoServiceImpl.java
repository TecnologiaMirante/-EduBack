package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.AvaliacaoDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.AvaliacaoMapper;
import br.com.mirante.eduapi.models.Avaliacao;
import br.com.mirante.eduapi.repository.AvaliacaoRepository;
import br.com.mirante.eduapi.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AvaliacaoServiceImpl implements AvaliacaoService {
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Override
    public Page<Avaliacao> findAll(Specification<Avaliacao> spec, Pageable page) {
        return avaliacaoRepository.findAll(spec, page);
    }

    @Override
    public AvaliacaoDTO save(AvaliacaoDTO avaliacaoDTO) throws BusinessException {

        Avaliacao avaliacao = AvaliacaoMapper.INSTANCE.ToAvaliacao(avaliacaoDTO);

        if (avaliacaoRepository.findById(avaliacao.getId()).isPresent()){
            throw new BusinessException("Avaliacao já existe com esse id");
        }
        avaliacao = avaliacaoRepository.save(avaliacao);

        return AvaliacaoMapper.INSTANCE.ToAvaliacaoDTO(avaliacao);
    }

    @Override
    public Optional<AvaliacaoDTO> findById(UUID id) {
        return avaliacaoRepository.findById(id)
                .map(AvaliacaoMapper.INSTANCE::ToAvaliacaoDTO);
    }

    @Override
    public Optional<AvaliacaoDTO> update(UUID id, AvaliacaoDTO avaliacaoDTO) {
        if (avaliacaoRepository.existsById(id)) {
            Avaliacao avaliacao = AvaliacaoMapper.INSTANCE.ToAvaliacao(avaliacaoDTO);
            avaliacao.setId(id);
            avaliacao = avaliacaoRepository.save(avaliacao);
            return Optional.of(AvaliacaoMapper.INSTANCE.ToAvaliacaoDTO(avaliacao));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID id) {
        if (avaliacaoRepository.existsById(id)) {
            avaliacaoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
