package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.*;
import br.com.mirante.eduapi.models.Aluno;
import br.com.mirante.eduapi.models.Escola;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;


@Mapper
public interface AlunoMapper {
    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    @Mappings({
            @Mapping(source = "usuarioAluno.usuarioEscola", target = "escola"),
    })
    AlunoDTO alunoToAlunoDTO(Aluno aluno);

    @Mappings({
            @Mapping(source = "userInfo.nome", target = "nome"),
            @Mapping(source = "userInfo.sexo", target = "sexo"),
            @Mapping(source = "userInfo.cpf", target = "cpf"),
            @Mapping(source = "userInfo.matricula", target = "matricula"),
    })
    @InheritInverseConfiguration
    UsuarioDTOGet alunoToUsuarioDTOGet(Aluno aluno);

    @Mappings({
            @Mapping(source = "escola", target = "usuarioAluno.usuarioEscola")
    })
    Aluno alunoDTOToAluno(AlunoDTO aluno);

    @Mappings({
            @Mapping(source = "usuarioAluno.id", target = "usuarioId"),
            @Mapping(source = "usuarioAluno.usuarioEscola.id", target = "escolaId"),
    })
    AlunoDTOPost alunoToAlunoPost(Aluno aluno);

    @Mappings({
            @Mapping(source = "usuarioId", target = "usuarioAluno.id"),
            @Mapping(source = "escolaId", target = "usuarioAluno.usuarioEscola.id")
    })
    Aluno alunoDTOPostToAluno(AlunoDTOPost aluno);
}