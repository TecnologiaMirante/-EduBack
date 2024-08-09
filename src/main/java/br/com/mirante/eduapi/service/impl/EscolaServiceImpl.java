package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.EscolaDTO;
import br.com.mirante.eduapi.dto.EscolaDTOPost;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.EscolaMapper;
import br.com.mirante.eduapi.models.Escola;
import br.com.mirante.eduapi.repository.EscolaRepository;
import br.com.mirante.eduapi.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class EscolaServiceImpl implements EscolaService {

    @Autowired
    private EscolaRepository escolaRepository;

    @Override
    public Page<Escola> findAll(Specification<Escola> spec, Pageable page) {
        return escolaRepository.findAll(spec, page);
    }

    @Override
    public EscolaDTOPost save(EscolaDTOPost escolaDTO) throws BusinessException {
        Pattern patternCpf = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
        Escola escola = EscolaMapper.INSTANCE.escolaDTOPostToEscola(escolaDTO);
        if (!patternCpf.matcher(escola.getCpfCnpj()).matches()){
            throw new BusinessException("CPF invalido, Tente novamente");
        }

        if (escolaRepository.findByCpfCnpj(escolaDTO.getCpfCnpj()) != null) {
            throw new BusinessException("Escola já cadastrada");
        }

        escola = escolaRepository.save(escola);
        return EscolaMapper.INSTANCE.escolaToEscolaDTOPost(escola);
    }

    @Override
    public Optional<EscolaDTO> findById(UUID id) {
        return escolaRepository.findById(id)
                .map(EscolaMapper.INSTANCE::escolaToEscolaDTO);
    }

    @Override
    public Optional<EscolaDTO> update(UUID id, EscolaDTO escolaDTO) {
        if (escolaRepository.existsById(id)) {
            Escola escola = EscolaMapper.INSTANCE.escolaDTOToEscola(escolaDTO);
            escola.setId(id);
            escola = escolaRepository.save(escola);
            return Optional.of(EscolaMapper.INSTANCE.escolaToEscolaDTO(escola));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (escolaRepository.existsById(id)) {
            escolaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
