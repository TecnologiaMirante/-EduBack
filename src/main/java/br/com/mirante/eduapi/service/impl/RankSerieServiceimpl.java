package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.RankSerieDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.RankSerieMapper;
import br.com.mirante.eduapi.models.RankSerie;
import br.com.mirante.eduapi.repository.RankSerieRepository;
import br.com.mirante.eduapi.service.RankSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RankSerieServiceimpl implements RankSerieService{

    @Autowired
    private RankSerieRepository rankSerieRepository;

    @Override
    public Page<RankSerie> findAll(Specification<RankSerie> spec, Pageable page) {
        return rankSerieRepository.findAll(spec, page);
    }
    @Override
    public Optional<RankSerieDTO> findById(UUID id) {
        return rankSerieRepository.findById(id).map(RankSerieMapper.INSTANCE::rankSerieToRankSerieDTO);
    }

    @Override
    public RankSerieDTO save(RankSerieDTO rankSerieDTO) throws BusinessException {
        RankSerie rankSerie = RankSerieMapper.INSTANCE.rankSerieDTOToRankSerie(rankSerieDTO);

        if (rankSerieRepository.findByPrimeiro(rankSerieDTO.getPrimeiro()) != null
                || rankSerieRepository.findBySegundo(rankSerieDTO.getSegundo()) != null
                || rankSerieRepository.findByTerceiro(rankSerieDTO.getTerceiro()) != null) {
            throw new BusinessException("Este usuário já está em um ranking.");
        }
        rankSerie = rankSerieRepository.save(rankSerie);
        return RankSerieMapper.INSTANCE.rankSerieToRankSerieDTO(rankSerie);
    }

    @Override
    public Optional<RankSerieDTO> update(UUID id, RankSerieDTO rankSerieDTO) {
        if (rankSerieRepository.existsById(id)) {
            RankSerie rankSerie = RankSerieMapper.INSTANCE.rankSerieDTOToRankSerie(rankSerieDTO);
            rankSerie.setId(id);
            rankSerie = rankSerieRepository.save(rankSerie);
            return Optional.of(RankSerieMapper.INSTANCE.rankSerieToRankSerieDTO(rankSerie));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        if (rankSerieRepository.existsById(id)) {
            rankSerieRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
