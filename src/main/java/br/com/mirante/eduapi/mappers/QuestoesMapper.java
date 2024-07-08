package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.QuestoesDTO;
import br.com.mirante.eduapi.models.Questoes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestoesMapper {
    QuestoesMapper INSTANCE = Mappers.getMapper(QuestoesMapper.class);
    Questoes questoesDTOToQuestoes(QuestoesDTO questoesDTO);
    QuestoesDTO questoesToQuestoesDTO(Questoes questoes);

}
