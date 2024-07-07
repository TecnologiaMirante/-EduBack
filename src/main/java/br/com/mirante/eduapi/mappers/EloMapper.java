package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.EloDTO;
import br.com.mirante.eduapi.models.Elo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EloMapper {
    EloMapper INSTANCE = Mappers.getMapper(EloMapper.class);
    EloDTO eloToDTO(Elo elo);
    Elo dtoToElo(EloDTO dto);

}
