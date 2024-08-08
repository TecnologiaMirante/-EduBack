package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.SerieDTO;
import br.com.mirante.eduapi.models.Serie;
import br.com.mirante.eduapi.service.SerieService;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SerieMapper {

    SerieMapper INSTANCE = Mappers.getMapper(SerieMapper.class);
    SerieDTO ToserieDTO(Serie serie);
    Serie Toserie(SerieDTO serieDTO);
}
