package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.models.Escola;
import br.com.mirante.eduapi.dto.EscolaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EscolaMapper {
    EscolaMapper INSTANCE = Mappers.getMapper(EscolaMapper.class);
    EscolaDTO escolaToEscolaDTO(Escola escola);
    Escola escolaDTOToEscola(EscolaDTO escolaDTO);
}
