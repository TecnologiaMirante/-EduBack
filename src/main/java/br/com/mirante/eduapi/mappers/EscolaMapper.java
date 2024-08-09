package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.*;
import br.com.mirante.eduapi.models.Aluno;
import br.com.mirante.eduapi.models.Escola;
import br.com.mirante.eduapi.models.Professor;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface EscolaMapper {
    EscolaMapper INSTANCE = Mappers.getMapper(EscolaMapper.class);

    EscolaDTO escolaToEscolaDTO(Escola escola);

    List<EscolaDTO> map(List<Escola> escola);

    Escola escolaDTOToEscola(EscolaDTO escolaDTO);

    EscolaDTOPost escolaToEscolaDTOPost(Escola escola);

    Escola escolaDTOPostToEscola(EscolaDTOPost escolaDTO);

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

    @Mapping(source = "professorEscola.id", target = "escolaId")
    ProfessorDTOGet professorToProfessorDTOGet(Professor professor);

    @Mapping(source = "escolaId", target = "professorEscola.id")
    @Mapping(source = "tipoUsuario", target = "tipoUsuario")
    Professor professorDTOGetToProfessor(ProfessorDTOGet professor);

}
