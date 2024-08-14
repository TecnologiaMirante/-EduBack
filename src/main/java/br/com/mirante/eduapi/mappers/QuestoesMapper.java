package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.QuestoesDTO;
import br.com.mirante.eduapi.dto.QuestoesDTOGet;
import br.com.mirante.eduapi.models.Questoes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestoesMapper {
    QuestoesMapper INSTANCE = Mappers.getMapper(QuestoesMapper.class);
    @Mappings({
            @Mapping(source = "avaliacao.id",target = "idAvaliacao"),
            @Mapping(source = "questoesOpcoesList",target = "idOpcoes")
    })
    QuestoesDTO questoesToQuestoesDTO(Questoes questoes);
    @Mappings({
            @Mapping(source = "idAvaliacao",target = "avaliacao.id"),
            @Mapping(source = "idOpcoes",target = "questoesOpcoesList")
    })
    Questoes questoesDTOToQuestoes(QuestoesDTO questoesDTO);


}
