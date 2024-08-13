package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.TurmaDTO;
import br.com.mirante.eduapi.models.Turma;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TurmaMapper {
    TurmaMapper INSTANCE = Mappers.getMapper(TurmaMapper.class);

    @Mapping(source = "serie.id", target = "id_serie")
    TurmaDTO ToturmaDTO(Turma turma);

    @Mapping(source = "id_serie", target = "serie.id")
    Turma Toturma(TurmaDTO turmaDTO);
}
