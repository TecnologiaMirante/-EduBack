package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.models.Escola;
import br.com.mirante.eduapi.dto.EscolaDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface EscolaMapper {
    EscolaMapper INSTANCE = Mappers.getMapper(EscolaMapper.class);

    @Mappings({
            @Mapping(source = "alunos", target = "alunos"),
            @Mapping(source = "usuarioList", target = "usuarios"),
    })
    @InheritInverseConfiguration
    EscolaDTO escolaToEscolaDTO(Escola escola);

    List<EscolaDTO> map(List<Escola> escola);

    Escola escolaDTOToEscola(EscolaDTO escolaDTO);
}
