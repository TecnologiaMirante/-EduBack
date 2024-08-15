package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.*;
import br.com.mirante.eduapi.models.Aluno;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Mapper
public interface AlunoMapper {
    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);


    @Mappings({
            @Mapping(source = "alunoEscola", target = "escola"),
            @Mapping(source = "responsavelAluno", target = "responsavel"),
            @Mapping(source = "turmaAluno", target = "turma"),
            @Mapping(source = "disciplinasAlunos", target = "disciplinas")
    })
    AlunoDTO alunoToAlunoDTO(Aluno aluno);

    @Mappings({
            @Mapping(source = "escola", target = "alunoEscola"),
            @Mapping(source = "responsavel", target = "responsavelAluno"),
            @Mapping(source = "turma", target = "turmaAluno"),
            @Mapping(source = "disciplinas", target = "disciplinasAlunos"),
            @Mapping(source = "conquistas", target = "conquistas")
    })
    Aluno alunoDTOToAluno(AlunoDTO aluno);

    @Mappings({
            @Mapping(source = "usuarioAluno.id", target = "usuarioId"),
            @Mapping(source = "alunoEscola.id", target = "escolaId"),
            @Mapping(source = "dataDeNascimento", target = "dataDeNascimento", qualifiedByName = "dateToString")
    })
    AlunoDTOPost alunoToAlunoPost(Aluno aluno);

    @Mappings({
            @Mapping(source = "usuarioId", target = "usuarioAluno.id"),
            @Mapping(source = "escolaId", target = "alunoEscola.id"),
            @Mapping(source = "tipoUsuario", target = "tipoUsuario"),
            @Mapping(source = "dataDeNascimento", target = "dataDeNascimento", qualifiedByName = "stringToDate")
    })
    Aluno alunoDTOPostToAluno(AlunoDTOPost aluno);

    @Mappings({
            @Mapping(source = "usuarioAluno.id", target = "usuarioId"),
            @Mapping(source = "id", target = "responsavel.id"),
            @Mapping(source = "alunoEscola", target = "escola")
    })
    AlunoDTOGet alunoToAlunoDTOGet(Aluno aluno);

    @Mappings({
            @Mapping(source = "usuarioId", target = "usuarioAluno.id"),
            @Mapping(source = "responsavel.id", target = "id"),
            @Mapping(source = "escola", target = "alunoEscola")
    })
    Aluno alunoDTOGetToAluno(AlunoDTOGet aluno);

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