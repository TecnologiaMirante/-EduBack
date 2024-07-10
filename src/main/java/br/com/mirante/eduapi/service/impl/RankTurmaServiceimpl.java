package br.com.mirante.eduapi.service.impl;


import br.com.mirante.eduapi.dto.RankTurmaDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.RankTurmaMapper;
import br.com.mirante.eduapi.models.RankTurma;
import br.com.mirante.eduapi.repository.RankTurmaRepository;
import br.com.mirante.eduapi.service.RankTurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RankTurmaServiceimpl implements RankTurmaService {

    @Autowired
    private RankTurmaRepository rankTurmaRepository;

    @Override
    public Page<RankTurma> findAll(Specification<RankTurma> spec, Pageable page) {
        return rankTurmaRepository.findAll(spec, page);
    }
    @Override
    public Optional<RankTurmaDTO> findById(UUID id) {
        return rankTurmaRepository.findById(id).map(RankTurmaMapper.INSTANCE::rankTurmaToRankTurmaDTO);
    }

    @Override
    public RankTurmaDTO save(RankTurmaDTO rankTurmaDTO) throws BusinessException {
        RankTurma rankTurma = RankTurmaMapper.INSTANCE.rankTurmaDTOToRankTurma(rankTurmaDTO);

        if (rankTurmaRepository.findByPrimeiro(rankTurmaDTO.getPrimeiro()) != null
                || rankTurmaRepository.findBySegundo(rankTurmaDTO.getSegundo()) != null
                || rankTurmaRepository.findByTerceiro(rankTurmaDTO.getTerceiro()) != null) {
            throw new BusinessException("Este usuário já está em um ranking.");
        }
        rankTurma = rankTurmaRepository.save(rankTurma);
        return RankTurmaMapper.INSTANCE.rankTurmaToRankTurmaDTO(rankTurma);
    }

    @Override
    public Optional<RankTurmaDTO> update(UUID id, RankTurmaDTO rankTurmaDTO) {
        if (rankTurmaRepository.existsById(id)) {
            RankTurma rankTurma = RankTurmaMapper.INSTANCE.rankTurmaDTOToRankTurma(rankTurmaDTO);
            rankTurma.setId(id);
            rankTurma = rankTurmaRepository.save(rankTurma);
            return Optional.of(RankTurmaMapper.INSTANCE.rankTurmaToRankTurmaDTO(rankTurma));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (rankTurmaRepository.existsById(id)) {
            rankTurmaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
