package br.com.mirante.eduapi.service.impl;


import br.com.mirante.eduapi.dto.RankAlunoDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.RankAlunoMapper;
import br.com.mirante.eduapi.models.RankAluno;
import br.com.mirante.eduapi.repository.RankAlunoRepository;
import br.com.mirante.eduapi.service.RankAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RankAlunoServiceimpl implements RankAlunoService {
    @Autowired
    private RankAlunoRepository rankAlunoRepository;

    @Override
    public Page<RankAluno> findAll(Specification<RankAluno> spec, Pageable page) {
        return rankAlunoRepository.findAll(spec, page);
    }

    @Override
    public Optional<RankAlunoDTO> findById(UUID id) {
        return rankAlunoRepository.findById(id).map(RankAlunoMapper.INSTANCE::rankAlunoToRankAlunoDTO);
    }

    @Override
    public RankAlunoDTO save(RankAlunoDTO rankAlunoDTO) throws BusinessException {
        RankAluno rankAluno = RankAlunoMapper.INSTANCE.rankAlunoDTORankAluno(rankAlunoDTO);
        rankAluno = rankAlunoRepository.save(rankAluno);
        return RankAlunoMapper.INSTANCE.rankAlunoToRankAlunoDTO(rankAluno);
    }

    @Override
    public Optional<RankAlunoDTO> update(UUID id, RankAlunoDTO rankAlunoDTO) {
        if (rankAlunoRepository.existsById(id)) {
            RankAluno rankAluno = RankAlunoMapper.INSTANCE.rankAlunoDTORankAluno(rankAlunoDTO);
            rankAluno.setId(id);
            rankAluno = rankAlunoRepository.save(rankAluno);
            return Optional.of(RankAlunoMapper.INSTANCE.rankAlunoToRankAlunoDTO(rankAluno));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (rankAlunoRepository.existsById(id)) {
            rankAlunoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
