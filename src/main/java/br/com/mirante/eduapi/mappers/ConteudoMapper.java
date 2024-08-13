package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.ConteudoDTO;
import br.com.mirante.eduapi.models.Conteudo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConteudoMapper {
    ConteudoMapper INSTANCE = Mappers.getMapper(ConteudoMapper.class);

    @Mapping(source = "bimestre.id", target = "id_bimestre")
    @Mapping(source = "disciplinaConteudo.id", target = "id_disciplina")
    @Mapping(source = "professorConteudo.id", target = "id_professor")
    ConteudoDTO ToConteudoDTO(Conteudo conteudo);

    @Mapping(source = "id_bimestre", target = "bimestre.id")
    @Mapping(source = "id_disciplina", target = "disciplinaConteudo.id")
    @Mapping(source = "id_professor", target = "professorConteudo.id")
    Conteudo ToConteudo(ConteudoDTO conteudoDTO);
}
