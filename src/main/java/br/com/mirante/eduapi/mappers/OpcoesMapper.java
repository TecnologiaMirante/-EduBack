package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.OpcoesDTO;
import br.com.mirante.eduapi.dto.QuestoesDTO;
import br.com.mirante.eduapi.dto.QuestoesDTOGet;
import br.com.mirante.eduapi.models.Opcoes;
import br.com.mirante.eduapi.models.Questoes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = QuestoesMapper.class)
public interface OpcoesMapper{
        OpcoesMapper INSTANCE = Mappers.getMapper(OpcoesMapper.class);

//    @Mappings({
//            @Mapping(source = "questoes", target = "questoesDTOS")
//    })
    OpcoesDTO opcoestoOpcoesDTO(Opcoes opcoes);

//    @Mappings({
//            @Mapping(source = "questoesDTOS", target = "questoes")
//    })
    Opcoes opcoesDTOtoOpcoes(OpcoesDTO opcoesDTO);

//    default List<QuestoesDTO> mapQuestoesToListQuestoesDTO(Questoes questoes) {
//        if (questoes == null) {
//            return null;
//        }
//        return List.of(QuestoesMapper.INSTANCE.questoesToQuestoesDTO(questoes));
//    }

//    default Questoes mapListQuestoesDTOToQuestoes(List<QuestoesDTO> questoesDTOS) {
//        if (questoesDTOS == null || questoesDTOS.isEmpty()) {
//            return null;
//        }
//        return QuestoesMapper.INSTANCE.questoesDTOToQuestoes(questoesDTOS.get(0));
//    }
//
//    default Questoes mapListQuestoesDTOGetToQuestoes(List<QuestoesDTOGet> questoesDTOS) {
//        if (questoesDTOS == null || questoesDTOS.isEmpty()) {
//            return null;
//        }
//        // Corrigido para usar o método certo do QuestoesMapper
//        return QuestoesMapper.INSTANCE.questoesDTOGetToQuestoes(questoesDTOS.get(0));
//    }
}