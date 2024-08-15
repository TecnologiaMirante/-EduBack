package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.DisciplinaDTO;
import br.com.mirante.eduapi.dto.DisciplinaDTOpost;
import br.com.mirante.eduapi.models.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Mapper
public interface DisciplinaMapper {
    DisciplinaMapper INSTANCE = Mappers.getMapper(DisciplinaMapper.class);

    @Mapping(source = "professorDisciplinaList", target = "profDisciplina")
    @Mapping(source = "conteudoDisciplinaList", target = "conteudoDisciplina")
    @Mapping(source = "turmaDisciplinaList", target = "turmaDisciplina")
    @Mapping(source = "alunoDisciplina", target = "alunoDisciplina")
    DisciplinaDTO ToDisciplinaDTO(Disciplina disciplina);

    @Mapping(source = "profDisciplina", target = "professorDisciplinaList")
    @Mapping(source = "conteudoDisciplina", target = "conteudoDisciplinaList")
    @Mapping(source = "turmaDisciplina", target = "turmaDisciplinaList")
    @Mapping(source = "alunoDisciplina", target = "alunoDisciplina")
    Disciplina ToDisciplina(DisciplinaDTO disciplinaDTO);

    @Mapping(source = "professorDisciplinaList", target = "id_professor",  qualifiedByName = "professorListToFirstId")
    @Mapping(source = "turmaDisciplinaList", target = "id_turma" ,qualifiedByName = "turmaListToFirstId")
    @Mapping(source = "conteudoDisciplinaList", target = "id_conteudo",  qualifiedByName = "conteudoListToFirstId")
    @Mapping(source = "alunoDisciplina", target = "id_aluno",  qualifiedByName = "alunoListToFirstId")
    DisciplinaDTOpost ToDisciplinaDTOpost(Disciplina disciplina);


    @Mapping(source = "id_professor", target = "professorDisciplinaList", qualifiedByName = "uuidToProfessorList")
    @Mapping(source = "id_turma", target = "turmaDisciplinaList", qualifiedByName = "uuidToTurmaList")
    @Mapping(source = "id_conteudo", target = "conteudoDisciplinaList", qualifiedByName = "uuidToConteudoList")
    @Mapping(source = "id_aluno", target = "alunoDisciplina", qualifiedByName = "uuidToAlunoList")
    Disciplina postToDisciplina(DisciplinaDTOpost disciplinaDTOpost);



    @Named("conteudoListToFirstId")
    static UUID conteudoListToFirstId(List<Conteudo> conteudos) {
        return conteudos.isEmpty() ? null : conteudos.get(0).getId();
    }


    @Named("uuidToConteudoList")
    static List<Conteudo> uuidToConteudoList(UUID uuid) {
        if (uuid == null) {
            return Collections.emptyList();
        }
        Conteudo conteudo = new Conteudo();
        conteudo.setId(uuid);
        return Collections.singletonList(conteudo);
    }

    @Named("alunoListToFirstId")
    static UUID alunoListToFirstId(List<Aluno> alunos) {
        return alunos.isEmpty() ? null : alunos.get(0).getId();
    }

    @Named("uuidToAlunoList")
    static List<Aluno> uuidToAlunoList(UUID uuid) {
        if (uuid == null) {
            return Collections.emptyList();
        }
        Aluno aluno = new Aluno();
        aluno.setId(uuid);
        return Collections.singletonList(aluno);
    }

    @Named("professorListToFirstId")
    static UUID professorListToFirstId(List<Professor> professors) {
        return professors.isEmpty() ? null : professors.get(0).getId();
    }

    @Named("uuidToProfessorList")
    static List<Professor> uuidToProfessorList(UUID uuid) {
        if (uuid == null) {
            return Collections.emptyList();
        }
        Professor professor = new Professor();
        professor.setId(uuid);
        return Collections.singletonList(professor);
    }

    @Named("turmaListToFirstId")
    static UUID turmaListToFirstId(List<Turma> turmas) {
        return turmas.isEmpty() ? null : turmas.get(0).getId();
    }

    @Named("uuidToTurmaList")
    static List<Turma> uuidToTurmaList(UUID uuid) {
        if (uuid == null) {
            return Collections.emptyList();
        }
        Turma turma = new Turma();
        turma.setId(uuid);
        return Collections.singletonList(turma);
    }
}


