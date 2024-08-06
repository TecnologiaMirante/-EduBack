package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.ProfessorDTO;
import br.com.mirante.eduapi.dto.ProfessorDTOGet;
import br.com.mirante.eduapi.dto.ProfessorDTOPost;
import br.com.mirante.eduapi.models.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfessorMapper {
    ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);

    @Mapping(source = "professorEscola", target = "escola")
    ProfessorDTO professorToProfessorDTO(Professor professor);

    @Mapping(source = "escola", target = "professorEscola")
    Professor professorDTOToProfessor(ProfessorDTO professorDTO);

    @Mappings({
            @Mapping(source = "professorEscola.id", target = "escolaId"),
            @Mapping(source = "usuarioProfessor.id", target = "usuarioId")
    })
    ProfessorDTOPost professorToProfessorDTOPost(Professor professor);

    @Mappings({
            @Mapping(source = "escolaId", target = "professorEscola.id"),
            @Mapping(source = "usuarioId", target = "usuarioProfessor.id")
    })
    Professor professorDTOPostToProfessor(ProfessorDTOPost professorDTO);

}
