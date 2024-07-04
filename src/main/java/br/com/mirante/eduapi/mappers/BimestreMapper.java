package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.BimestreDTO;
import br.com.mirante.eduapi.models.Bimestre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BimestreMapper {
    BimestreMapper INSTANCE = Mappers.getMapper(BimestreMapper.class);
    BimestreDTO ToBimestreDTO(Bimestre bimestre);
    Bimestre ToBimestre(BimestreDTO bimestreDTO);
}
