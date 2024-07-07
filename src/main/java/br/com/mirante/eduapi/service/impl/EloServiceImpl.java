package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.EloDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.EloMapper;
import br.com.mirante.eduapi.models.Elo;
import br.com.mirante.eduapi.repository.EloRepository;
import br.com.mirante.eduapi.service.EloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EloServiceImpl implements EloService {
    @Autowired
    private EloRepository eloRepository;

    @Override
    public Page<Elo> findAll(Specification<Elo> spec, Pageable page) {
        return eloRepository.findAll(spec, page);
    }

    @Override
    public EloDTO save(EloDTO eloDTO) throws BusinessException {
        Elo elo = EloMapper.INSTANCE.dtoToElo(eloDTO);
        elo = eloRepository.save(elo);

        return EloMapper.INSTANCE.eloToDTO(elo);
    }

    @Override
    public Optional<EloDTO> findById(UUID id) {
        return eloRepository.findById(id)
                .map(EloMapper.INSTANCE::eloToDTO);
    }

    @Override
    public Optional<EloDTO> update(UUID id, EloDTO eloDTO) {
        if (eloRepository.existsById(id)) {
            Elo elo = EloMapper.INSTANCE.dtoToElo(eloDTO);
            elo.setId(id);
            elo = eloRepository.save(elo);
            return Optional.of(EloMapper.INSTANCE.eloToDTO(elo));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (eloRepository.existsById(id)) {
            eloRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
