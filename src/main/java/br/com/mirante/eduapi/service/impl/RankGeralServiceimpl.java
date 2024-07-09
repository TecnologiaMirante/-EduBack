package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.QuestoesDTO;
import br.com.mirante.eduapi.dto.RankGeralDTO;
import br.com.mirante.eduapi.mappers.QuestoesMapper;
import br.com.mirante.eduapi.mappers.RankGeralMapper;
import br.com.mirante.eduapi.models.Questoes;
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
public class RankGeralServiceimpl implements RankGeralService {

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

}
