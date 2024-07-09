package br.com.mirante.eduapi.mappers;


import br.com.mirante.eduapi.dto.RankTurmaDTO;
import br.com.mirante.eduapi.models.RankTurma;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RankTurmaMapper {
    RankTurmaMapper INSTANCE = Mappers.getMapper(RankTurmaMapper.class);
    RankTurma rankTurmaDTOToRankTurma(RankTurmaDTO rankTurmaDTO);
    RankTurmaDTO rankTurmaToRankTurmaDTO(RankTurma rankTurma);
}
