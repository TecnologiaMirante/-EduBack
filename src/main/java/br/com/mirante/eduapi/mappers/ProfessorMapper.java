package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.ProfessorDTO;
import br.com.mirante.eduapi.dto.ProfessorDTOGet;
import br.com.mirante.eduapi.models.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfessorMapper {
    ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);

    @Mapping(source = "usuarioProfessor.usuarioEscola.id", target = "escolaId")
    @Mapping(source = "usuarioProfessor.id", target = "usuarioId")
    ProfessorDTO professorToProfessorDTO(Professor professor);

    @Mapping(source = "escolaId", target = "usuarioProfessor.usuarioEscola.id")
    @Mapping(source = "usuarioId", target = "usuarioProfessor.id")
    Professor professorDTOToProfessor(ProfessorDTO professorDTO);

    ProfessorDTOGet professortoProfessorGetDTO(Professor professor);
    Professor professorDTOGetToProfessor(ProfessorDTOGet professorDTO);
}
