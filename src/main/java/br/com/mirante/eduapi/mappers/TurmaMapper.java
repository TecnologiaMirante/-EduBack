package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.TurmaDTO;
import br.com.mirante.eduapi.models.Turma;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TurmaMapper {
    TurmaMapper INSTANCE = Mappers.getMapper(TurmaMapper.class);
    TurmaDTO ToturmaDTO(Turma turma);
    Turma Toturma(TurmaDTO turmaDTO);
}
