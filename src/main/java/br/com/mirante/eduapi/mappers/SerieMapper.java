package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.SerieDTO;
import br.com.mirante.eduapi.dto.SerieDTOpost;
import br.com.mirante.eduapi.models.Aluno;
import br.com.mirante.eduapi.models.RankAluno;
import br.com.mirante.eduapi.models.Serie;
import br.com.mirante.eduapi.models.Turma;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Mapper
public interface SerieMapper {

    SerieMapper INSTANCE = Mappers.getMapper(SerieMapper.class);

    @Mapping(source = "serieAluno", target = "aluno")
    @Mapping(source = "turmaSerieList", target = "turmaSerie")
    @Mapping(source = "rankAlunoSerieList", target = "rankAluno")
    SerieDTO ToserieDTO(Serie serie);


    @Mapping(source = "aluno", target = "serieAluno")
    @Mapping(source = "turmaSerie", target = "turmaSerieList")
    @Mapping(source = "rankAluno", target = "rankAlunoSerieList")
    Serie Toserie(SerieDTO serieDTO);



    @Mapping(source = "serieAluno", target = "id_aluno", qualifiedByName = "alunoListToFirstId")
    @Mapping(source = "turmaSerieList", target = "id_turma", qualifiedByName = "turmaListToFirstId")
    @Mapping(source = "rankAlunoSerieList", target = "id_rankAluno", qualifiedByName = "rankAlunoListToFirstId")
    //@Mapping(source = "turmaSerieList", target = "")
    SerieDTOpost ToSerieDTOpost(Serie serie);


    @Mapping(source = "id_aluno", target = "serieAluno", qualifiedByName = "uuidToAlunoList")
    @Mapping(source = "id_turma", target = "turmaSerieList", qualifiedByName = "uuidToTurmaList")
    @Mapping(source = "id_rankAluno", target = "rankAlunoSerieList", qualifiedByName = "uuidToRankAlunoList")
        //@Mapping(source = "", target = "turmaSerieList")
    Serie DTOtoSerie(SerieDTOpost serieDTOpost);


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

    @Named("rankAlunoListToFirstId")
    static UUID rankAlunoListToFirstId(List<RankAluno> rankAlunos) {
        return rankAlunos.isEmpty() ? null : rankAlunos.get(0).getId();
    }

    @Named("uuidToRankAlunoList")
    static List<RankAluno> uuidToRankAlunoList(UUID uuid) {
        if (uuid == null) {
            return Collections.emptyList();
        }
        RankAluno rankAluno = new RankAluno();
        rankAluno.setId(uuid);
        return Collections.singletonList(rankAluno);
    }
}
