package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.*;
import br.com.mirante.eduapi.models.Aluno;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlunoMapper {
    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);


    @Mappings({
            @Mapping(source = "alunoEscola", target = "escola"),
            @Mapping(source = "responsavelAluno", target = "responsavel")
    })
    AlunoDTO alunoToAlunoDTO(Aluno aluno);

    @Mappings({
            @Mapping(source = "escola", target = "alunoEscola"),
            @Mapping(source = "responsavel", target = "responsavelAluno")
    })
    Aluno alunoDTOToAluno(AlunoDTO aluno);

    @Mappings({
            @Mapping(source = "usuarioAluno.id", target = "usuarioId"),
            @Mapping(source = "alunoEscola.id", target = "escolaId"),
    })
    AlunoDTOPost alunoToAlunoPost(Aluno aluno);

    @Mappings({
            @Mapping(source = "usuarioId", target = "usuarioAluno.id"),
            @Mapping(source = "escolaId", target = "alunoEscola.id"),
            @Mapping(source = "tipoUsuario", target = "tipoUsuario")
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
}