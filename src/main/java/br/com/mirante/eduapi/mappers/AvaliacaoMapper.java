package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.AvaliacaoDTO;
import br.com.mirante.eduapi.models.Avaliacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface    AvaliacaoMapper {
    AvaliacaoMapper INSTANCE = Mappers.getMapper(AvaliacaoMapper.class);

//    @Mapping(source = "questoesAvaliacaoList", target = "id_questoes")
//    @Mapping(source = "notaAvaliacaoList", target = "id_nota")
//    @Mapping(source = "avaliacaoConteudoList", target = "id_conteudo")
    AvaliacaoDTO ToAvaliacaoDTO(Avaliacao avaliacao);

//    @Mapping(source = "id_questoes", target = "questoesAvaliacaoList")
//    @Mapping(source = "id_nota", target = "notaAvaliacaoList")
//    @Mapping(source = "id_conteudo", target = "avaliacaoConteudoList")
    Avaliacao ToAvaliacao(AvaliacaoDTO avaliacaoDTO);

}
