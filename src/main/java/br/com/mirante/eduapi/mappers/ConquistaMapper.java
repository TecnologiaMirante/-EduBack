package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.ConquistasDTO;
import br.com.mirante.eduapi.models.Conquistas;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConquistaMapper {
    ConquistaMapper INSTANCE = Mappers.getMapper(ConquistaMapper.class);
    ConquistasDTO conquistasToDTO(Conquistas conquistas);
    Conquistas DTOtoConquistas(ConquistasDTO conquistasDTO);
}
