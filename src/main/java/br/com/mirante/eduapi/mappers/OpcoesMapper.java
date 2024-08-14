package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.OpcoesDTO;
import br.com.mirante.eduapi.models.Opcoes;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

public interface OpcoesMapper {
    OpcoesMapper INSTANCE = Mappers.getMapper(OpcoesMapper.class);


    OpcoesDTO opcoestoOpcoesDTO(Opcoes opcoes);


    Opcoes opcoesDTOtoOpcoes(OpcoesDTO opcoesDTO);
}
