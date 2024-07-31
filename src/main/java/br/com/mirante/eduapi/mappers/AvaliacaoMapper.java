package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.AvaliacaoDTO;
import br.com.mirante.eduapi.models.Avaliacao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AvaliacaoMapper {
    AvaliacaoMapper INSTANCE = Mappers.getMapper(AvaliacaoMapper.class);
    AvaliacaoDTO ToAvaliacaoDTO(Avaliacao avaliacao);
    Avaliacao ToAvaliacao(AvaliacaoDTO avaliacaoDTO);

}
