package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.ProfessorDTO;
import br.com.mirante.eduapi.models.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfessorMapper {
    ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);
    ProfessorDTO professorToProfessorDTO(Professor professor);
    Professor professorDTOToProfessor(ProfessorDTO professorDTO);

/*    ProfessorDTOGet professortoProfessorGetDTO(Professor professor);
    Professor professorDTOGetToProfessor(ProfessorDTOGet professorDTO);*/
}
