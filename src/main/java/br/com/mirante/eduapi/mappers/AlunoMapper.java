package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.*;
import br.com.mirante.eduapi.models.Aluno;
import br.com.mirante.eduapi.models.Escola;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;


@Mapper
public interface AlunoMapper {
    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    @Mapping(source = "alunoEscola", target = "escola")
    AlunoDTO alunoToAlunoDTO(Aluno aluno);

    @Mapping(source = "escola", target = "alunoEscola")
    Aluno alunoDTOToAluno(AlunoDTO aluno);

    @Mappings({
            @Mapping(source = "usuarioAluno.id", target = "usuarioId"),
            @Mapping(source = "alunoEscola.id", target = "escolaId")
    })
    AlunoDTOPost alunoToAlunoPost(Aluno aluno);

    @Mappings({
            @Mapping(source = "usuarioId", target = "usuarioAluno.id"),
            @Mapping(source = "escolaId", target = "alunoEscola.id")
    })
    Aluno alunoDTOPostToAluno(AlunoDTOPost aluno);


}