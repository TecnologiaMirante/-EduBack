package br.com.mirante.eduapi.service.impl;


import br.com.mirante.eduapi.dto.RankAlunoDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.RankAlunoMapper;
import br.com.mirante.eduapi.models.RankAluno;
import br.com.mirante.eduapi.repository.RankAlunoRepository;
import br.com.mirante.eduapi.service.RankAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RankAlunoServiceimpl implements RankAlunoService {
    @Autowired
    private RankAlunoRepository rankAlunoRepository;

    @Override
    public Page<RankAluno> findAll(Specification<RankAluno> spec, Pageable page) {
        // Recuperar todos os registros ordenados por pontuação
        List<RankAluno> allRankings = rankAlunoRepository.findAll(spec, Pageable.unpaged()).getContent();

        // Ordenar os registros para garantir que todos com a mesma pontuação sejam agrupados
        allRankings.sort(Comparator.comparing(RankAluno::getPoints).reversed());

        // Encontrar a 5ª maior pontuação
        int limit = Math.min(5, allRankings.size());
        int fifthPlaceScore = allRankings.get(limit - 1).getPoints();

        // Filtrar os registros para incluir todos que tenham pontuação maior ou igual à 5ª maior pontuação
        List<RankAluno> topRankings = allRankings.stream()
                .filter(rank -> rank.getPoints()>= fifthPlaceScore)
                .collect(Collectors.toList());

        // Paginar os resultados conforme solicitado
        int start = Math.toIntExact(page.getOffset());
        int end = Math.min((start + page.getPageSize()), topRankings.size());
        List<RankAluno> paginatedList = topRankings.subList(start, end);

        return new PageImpl<>(paginatedList, page, topRankings.size());
    }

    @Override
    public Optional<RankAlunoDTO> findById(UUID id) {
        return rankAlunoRepository.findById(id).map(RankAlunoMapper.INSTANCE::rankAlunoToRankAlunoDTO);
    }

    @Override
    public RankAlunoDTO save(RankAlunoDTO rankAlunoDTO) throws BusinessException {
        RankAluno rankAluno = RankAlunoMapper.INSTANCE.rankAlunoDTORankAluno(rankAlunoDTO);
        if (rankAlunoRepository.findByApelido(rankAlunoDTO.getApelido()) != null){
            throw new BusinessException("Este apelido já existe");
        }

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
