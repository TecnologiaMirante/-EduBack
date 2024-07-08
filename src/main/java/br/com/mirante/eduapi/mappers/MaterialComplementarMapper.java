package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.MaterialComplementarDTO;
import br.com.mirante.eduapi.models.MaterialComplementar;
import org.mapstruct.factory.Mappers;

public interface MaterialComplementarMapper {
    MaterialComplementarMapper INSTANCE = Mappers.getMapper(MaterialComplementarMapper.class);
    MaterialComplementarDTO ToMaterialComplementarDTO(MaterialComplementar materialComplementar);
    MaterialComplementar ToMaterialComplementar(MaterialComplementarDTO materialComplementarDTO);
}
