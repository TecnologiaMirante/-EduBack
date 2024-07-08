package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.OpcoesDTO;
import br.com.mirante.eduapi.models.Opcoes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OpcoesMapper {
    OpcoesMapper INSTANCE = Mappers.getMapper(OpcoesMapper.class);
    OpcoesDTO opcoestoOpcoesDTO(Opcoes opcoes);
    Opcoes opcoesDTOtoOpcoes(OpcoesDTO opcoesDTO);
}
