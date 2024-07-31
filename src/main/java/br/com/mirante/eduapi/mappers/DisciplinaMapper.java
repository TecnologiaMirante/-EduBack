package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.DisciplinaDTO;
import br.com.mirante.eduapi.models.Disciplina;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DisciplinaMapper {
    DisciplinaMapper INSTANCE = Mappers.getMapper(DisciplinaMapper.class);
    DisciplinaDTO ToDisciplinaDTO(Disciplina disciplina);
    Disciplina ToDisciplina(DisciplinaDTO disciplinaDTO);

}
