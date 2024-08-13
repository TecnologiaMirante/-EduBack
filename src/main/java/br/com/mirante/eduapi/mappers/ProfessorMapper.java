package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.ProfessorDTO;
import br.com.mirante.eduapi.dto.ProfessorDTOGet;
import br.com.mirante.eduapi.dto.ProfessorDTOPost;
import br.com.mirante.eduapi.models.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Mapper
public interface ProfessorMapper {
    ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);

    @Mapping(source = "professorEscola", target = "escola")
    ProfessorDTO professorToProfessorDTO(Professor professor);

    @Mapping(source = "escola", target = "professorEscola")
    Professor professorDTOToProfessor(ProfessorDTO professorDTO);

    @Mappings({
            @Mapping(source = "professorEscola.id", target = "escolaId"),
            @Mapping(source = "usuarioProfessor.id", target = "usuarioId"),
            @Mapping(source = "dataDeNascimento", target = "dataDeNascimento", qualifiedByName = "dateToString")
    })
    ProfessorDTOPost professorToProfessorDTOPost(Professor professor);

    @Mappings({
            @Mapping(source = "escolaId", target = "professorEscola.id"),
            @Mapping(source = "usuarioId", target = "usuarioProfessor.id"),
            @Mapping(source = "tipoUsuario", target = "tipoUsuario"),
            @Mapping(source = "dataDeNascimento", target = "dataDeNascimento", qualifiedByName = "stringToDate")
    })
    Professor professorDTOPostToProfessor(ProfessorDTOPost professorDTO);

    @Named("dateToString")
    default String dateToString(Date date) {
        if (date != null) {
            return new SimpleDateFormat("yyyy-MM-dd").format(date);
        }
        return null;
    }

    @Named("stringToDate")
    default Date stringToDate(String date) {
        try{
            if (date != null){
                return new SimpleDateFormat("yyyy-MM-dd").parse(date);
            }
            else {
                return null;
            }
        }catch (ParseException e){
            e.printStackTrace();
            return  null;
        }
    }

}
