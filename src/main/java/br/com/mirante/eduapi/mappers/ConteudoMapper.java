package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.ConteudoDTO;
import br.com.mirante.eduapi.models.Conteudo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConteudoMapper {
    ConteudoMapper INSTANCE = Mappers.getMapper(ConteudoMapper.class);
    ConteudoDTO ToConteudoDTO(Conteudo conteudo);
    Conteudo ToConteudo(ConteudoDTO conteudoDTO);
}
