package br.com.mirante.eduapi.mappers;


import br.com.mirante.eduapi.dto.RankAlunoDTO;
import br.com.mirante.eduapi.dto.RankAlunoGetDTO;
import br.com.mirante.eduapi.models.RankAluno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RankAlunoMapper {
    RankAlunoMapper INSTANCE = Mappers.getMapper(RankAlunoMapper.class);

    @Mappings({
            @Mapping(source = "rankAlunos.id",target = "idAluno"),
            @Mapping(source = "serieListSerie.id",target = "idSerie"),
            @Mapping(source = "escola.id",target = "idEscola")
    })
    RankAlunoDTO rankAlunoToRankAlunoDTO(RankAluno rankAluno);

    @Mappings({
            @Mapping(source = "idAluno",target = "aluno.id"),
            @Mapping(source = "idSerie",target = "serieListSerie.id"),
            @Mapping(source = "idEscola",target = "escola.id")
    })
    RankAluno rankAlunoDTORankAluno(RankAlunoDTO rankAlunoDTO);

    RankAlunoGetDTO rankAlunoToRankAlunoGEt(RankAluno rankAluno);
}
