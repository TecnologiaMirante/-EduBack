package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.AulaDTO;
import br.com.mirante.eduapi.dto.AulaDTOGet;
import br.com.mirante.eduapi.models.Aula;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AulaMapper {
    AulaMapper INSTANCE = Mappers.getMapper(AulaMapper.class);
    @Mappings({
            @Mapping(source = "aluno.id",target = "idAluno"),
            @Mapping(source = "alunoInteracaos", target = "alunointeracoe")
    })
    AulaDTO aulaToAulaDTO(Aula aula);

    @Mappings({
            @Mapping(source = "idAluno",target = "aluno.id"),
            @Mapping(source = "alunointeracoe", target = "alunoInteracaos")
    })
    Aula aulaDTOToAula(AulaDTO aulaDTO);

    AulaDTOGet aulaToAulaDTOGet(Aula aula);
}
