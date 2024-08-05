package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.AulaDTO;
import br.com.mirante.eduapi.dto.AulaDTOGet;
import br.com.mirante.eduapi.models.Aula;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AulaMapper {
    AulaMapper INSTANCE = Mappers.getMapper(AulaMapper.class);
    AulaDTO aulaToAulaDTO(Aula aula);
    Aula aulaDTOToAula(AulaDTO aulaDTO);

    AulaDTOGet aulaToAulaDTOGet(Aula aula);
}
