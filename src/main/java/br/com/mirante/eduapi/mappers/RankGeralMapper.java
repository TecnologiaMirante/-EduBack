package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.RankGeralDTO;
import br.com.mirante.eduapi.models.RankGeral;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RankGeralMapper {
    RankGeralMapper INSTANCE = Mappers.getMapper(RankGeralMapper.class);
    RankGeral rankGeralDTOToRankGeral(RankGeralDTO rankGeralDTO);
    RankGeralDTO rankGeralToRankGeralDTO(RankGeral rankGeral);
}
