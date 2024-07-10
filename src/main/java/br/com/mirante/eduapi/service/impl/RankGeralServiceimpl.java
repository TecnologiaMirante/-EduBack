package br.com.mirante.eduapi.service.impl;


import br.com.mirante.eduapi.dto.RankGeralDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.RankGeralMapper;
import br.com.mirante.eduapi.models.RankGeral;
import br.com.mirante.eduapi.repository.RankGeralRepository;
import br.com.mirante.eduapi.service.RankGeralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RankGeralServiceimpl implements RankGeralService{

    @Autowired
    private RankGeralRepository rankGeralRepository;

    @Override
    public Page<RankGeral> findAll(Specification<RankGeral> spec, Pageable page) {
        return rankGeralRepository.findAll(spec, page);
    }
    @Override
    public Optional<RankGeralDTO> findById(UUID id) {
        return rankGeralRepository.findById(id).map(RankGeralMapper.INSTANCE::rankGeralToRankGeralDTO);
    }

    @Override
    public RankGeralDTO save(RankGeralDTO rankGeralDTO) throws BusinessException {
        RankGeral rankGeral = RankGeralMapper.INSTANCE.rankGeralDTOToRankGeral(rankGeralDTO);

        if (rankGeralRepository.findByPrimeiro(rankGeralDTO.getPrimeiro()) != null
                || rankGeralRepository.findBySegundo(rankGeralDTO.getSegundo()) != null
                || rankGeralRepository.findByTerceiro(rankGeralDTO.getTerceiro()) != null) {
            throw new BusinessException("Este usuário já está em um ranking.");
        }
        rankGeral = rankGeralRepository.save(rankGeral);
        return RankGeralMapper.INSTANCE.rankGeralToRankGeralDTO(rankGeral);
    }

    @Override
    public Optional<RankGeralDTO> update(UUID id, RankGeralDTO rankGeralDTO) {
        if (rankGeralRepository.existsById(id)) {
            RankGeral rankGeral = RankGeralMapper.INSTANCE.rankGeralDTOToRankGeral(rankGeralDTO);
            rankGeral.setId(id);
            rankGeral = rankGeralRepository.save(rankGeral);
            return Optional.of(RankGeralMapper.INSTANCE.rankGeralToRankGeralDTO(rankGeral));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (rankGeralRepository.existsById(id)) {
            rankGeralRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
