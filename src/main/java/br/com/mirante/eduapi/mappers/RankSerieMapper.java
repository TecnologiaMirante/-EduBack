package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.RankSerieDTO;
import br.com.mirante.eduapi.models.RankSerie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RankSerieMapper {
    RankSerieMapper INSTANCE = Mappers.getMapper(RankSerieMapper.class);
    RankSerieDTO rankSerieToRankSerieDTO(RankSerie rankSerie);
    RankSerie rankSerieDTOToRankSerie(RankSerieDTO rankSerieDTO);
}
