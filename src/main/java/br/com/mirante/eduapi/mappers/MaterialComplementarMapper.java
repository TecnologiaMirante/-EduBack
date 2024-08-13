package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.MaterialComplementarDTO;
import br.com.mirante.eduapi.models.MaterialComplementar;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MaterialComplementarMapper {
    MaterialComplementarMapper INSTANCE = Mappers.getMapper(MaterialComplementarMapper.class);

    @Mapping(source = "conteudosComplementares.id", target = "id_conteudo")
    MaterialComplementarDTO ToMaterialComplementarDTO(MaterialComplementar materialComplementar);

    @Mapping(source = "id_conteudo", target = "conteudosComplementares.id")
    MaterialComplementar ToMaterialComplementar(MaterialComplementarDTO materialComplementarDTO);
}
