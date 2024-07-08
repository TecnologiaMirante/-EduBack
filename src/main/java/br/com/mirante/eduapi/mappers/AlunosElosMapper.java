package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.AlunosEloDTO;
import br.com.mirante.eduapi.models.AlunosElo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlunosElosMapper {
    AlunosElosMapper INSTANCE = Mappers.getMapper(AlunosElosMapper.class);
    AlunosEloDTO alunosEloToAlunosEloDTO(AlunosElo aluno);
    AlunosElo alunosEloDTOToAlunosElo(AlunosEloDTO alunoDTO);
}
