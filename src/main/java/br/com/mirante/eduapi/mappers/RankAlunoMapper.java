package br.com.mirante.eduapi.mappers;


import br.com.mirante.eduapi.dto.RankAlunoDTO;
import br.com.mirante.eduapi.models.RankAluno;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RankAlunoMapper {
    RankAlunoMapper INSTANCE = Mappers.getMapper(RankAlunoMapper.class);
    RankAlunoDTO rankAlunoToRankAlunoDTO(RankAluno rankAluno);
    RankAluno rankAlunoDTORankAluno(RankAlunoDTO rankAlunoDTO);
}
