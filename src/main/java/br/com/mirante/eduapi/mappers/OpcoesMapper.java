package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.OpcoesDTO;
import br.com.mirante.eduapi.models.Opcoes;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

public interface OpcoesMapper {
    OpcoesMapper INSTANCE = Mappers.getMapper(OpcoesMapper.class);

    @Mappings({
            @Mapping(source = "questoes", target = "questoesDTOS")
    })
    OpcoesDTO opcoestoOpcoesDTO(Opcoes opcoes);

    @Mappings({
            @Mapping(source = "questoesDTOS", target = "questoes")
    })
    Opcoes opcoesDTOtoOpcoes(OpcoesDTO opcoesDTO);
}
