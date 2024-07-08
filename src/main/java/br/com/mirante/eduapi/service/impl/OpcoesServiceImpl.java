package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.OpcoesDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.OpcoesMapper;
import br.com.mirante.eduapi.models.Opcoes;
import br.com.mirante.eduapi.repository.OpcaoRepository;
import br.com.mirante.eduapi.service.OpcoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OpcoesServiceImpl implements OpcoesService {
    @Autowired
    public OpcaoRepository opcaoRepository;

    @Override
    public Page<Opcoes> findAll(Specification<Opcoes> spec, Pageable page) {
        return  opcaoRepository.findAll(spec, page);
    }

    @Override
    public Optional<OpcoesDTO> findById(UUID id) {
        return  opcaoRepository.findById(id)
                .map(OpcoesMapper.INSTANCE::opcoestoOpcoesDTO);
    }

    @Override
    public OpcoesDTO save(OpcoesDTO opcoesDTO) throws BusinessException{
        Opcoes opcoes = OpcoesMapper.INSTANCE.opcoesDTOtoOpcoes(opcoesDTO);
        opcoes = opcaoRepository.save(opcoes);
        return OpcoesMapper.INSTANCE.opcoestoOpcoesDTO(opcoes);
    }

    @Override
    public Optional<OpcoesDTO> update(UUID id, OpcoesDTO opcoesDTO) {
        if (opcaoRepository.existsById(id)){
            Opcoes opcoes = OpcoesMapper.INSTANCE.opcoesDTOtoOpcoes(opcoesDTO);
            opcoes.setId(id);
            opcoes = opcaoRepository.save(opcoes);
            return Optional.of(OpcoesMapper.INSTANCE.opcoestoOpcoesDTO(opcoes));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (opcaoRepository.existsById(id)){
            opcaoRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
