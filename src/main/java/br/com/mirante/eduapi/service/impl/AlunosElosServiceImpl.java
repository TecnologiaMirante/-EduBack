package br.com.mirante.eduapi.service.impl;


import br.com.mirante.eduapi.dto.AlunosEloDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.AdminMapper;
import br.com.mirante.eduapi.mappers.AlunosElosMapper;
import br.com.mirante.eduapi.models.Admin;
import br.com.mirante.eduapi.models.AlunosElo;
import br.com.mirante.eduapi.repository.AlunoEloRepository;
import br.com.mirante.eduapi.service.AlunoEloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AlunosElosServiceImpl implements AlunoEloService {
    @Autowired
    private AlunoEloRepository alunoEloRepository;


    @Override
    public Page<AlunosElo> findAll(Specification<AlunosElo> spec, Pageable page) {
        return alunoEloRepository.findAll(spec, page);
    }

    @Override
    public AlunosEloDTO save(AlunosEloDTO alunosEloDTO) throws BusinessException {
        AlunosElo alunosElo = AlunosElosMapper.INSTANCE.alunosEloDTOToAlunosElo(alunosEloDTO);

        alunosElo = alunoEloRepository.save(alunosElo);

        return AlunosElosMapper.INSTANCE.alunosEloToAlunosEloDTO(alunosElo);
    }

    @Override
    public Optional<AlunosEloDTO> findById(UUID id) {
        return alunoEloRepository.findById(id)
                .map(AlunosElosMapper.INSTANCE::alunosEloToAlunosEloDTO);
    }

    @Override
    public Optional<AlunosEloDTO> update(UUID id, AlunosEloDTO alunosEloDTO) {
        if (alunoEloRepository.existsById(id)) {
            AlunosElo alunosElo = AlunosElosMapper.INSTANCE.alunosEloDTOToAlunosElo(alunosEloDTO);
            alunosElo.setId(id);
            alunoEloRepository.save(alunosElo);

            return Optional.of(AlunosElosMapper.INSTANCE.alunosEloToAlunosEloDTO(alunosElo));
        }

        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (alunoEloRepository.existsById(id)){
            alunoEloRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
