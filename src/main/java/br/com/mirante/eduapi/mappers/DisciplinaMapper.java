package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.DisciplinaDTO;
import br.com.mirante.eduapi.models.Disciplina;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DisciplinaMapper {
    DisciplinaMapper INSTANCE = Mappers.getMapper(DisciplinaMapper.class);

//    @Mapping(source = "professorDisciplinaList", target = "profDisciplina")
//    @Mapping(source = "conteudoDisciplinaList", target = "conteudoDisciplina")
//    @Mapping(source = "turmaDisciplinaList", target = "turmaDisciplina")
    DisciplinaDTO ToDisciplinaDTO(Disciplina disciplina);

//    @Mapping(source = "profDisciplina", target = "professorDisciplinaList")
//    @Mapping(source = "conteudoDisciplina", target = "conteudoDisciplinaList")
//    @Mapping(source = "turmaDisciplina", target = "turmaDisciplinaList")
    Disciplina ToDisciplina(DisciplinaDTO disciplinaDTO);

}
