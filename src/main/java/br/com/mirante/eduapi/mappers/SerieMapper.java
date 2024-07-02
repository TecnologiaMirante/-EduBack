package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.SerieDTO;
import br.com.mirante.eduapi.models.Serie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SerieMapper {
    SerieMapper INSTANCE = Mappers.getMapper(SerieMapper.class);
    SerieDTO serieToserieDTO(Serie serie);
    Serie serieToserieDTO(SerieDTO serieDTO);
}
