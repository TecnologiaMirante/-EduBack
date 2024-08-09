package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.AlunoEloPost;
import br.com.mirante.eduapi.dto.AlunosEloDTO;
import br.com.mirante.eduapi.models.AlunosElo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlunosElosMapper {
    AlunosElosMapper INSTANCE = Mappers.getMapper(AlunosElosMapper.class);

    @Mappings({
            @Mapping(source = "alunoElo", target = "aluno"),
            @Mapping(source = "eloAluno", target = "elo")
    })
    AlunosEloDTO alunosEloToAlunosEloDTO(AlunosElo aluno);

    @Mappings({
            @Mapping(source = "aluno", target = "alunoElo"),
            @Mapping(source = "elo", target = "eloAluno")
    })
    AlunosElo alunosEloDTOToAlunosElo(AlunosEloDTO alunoDTO);

    @Mappings({
            @Mapping(source = "alunoElo.id", target = "alunoId"),
            @Mapping(source = "eloAluno.id", target = "eloId")
    })
    AlunoEloPost alunosElosToAlunosEloPost(AlunosElo alunosElo);

    @Mappings({
            @Mapping(source = "alunoId", target = "alunoElo.id"),
            @Mapping(source = "eloId", target = "eloAluno.id")
    })
    AlunosElo alunosElosPostToAlunosElo(AlunoEloPost alunoEloPost);
}
