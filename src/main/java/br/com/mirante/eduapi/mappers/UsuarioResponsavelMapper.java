package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.UsuarioResponsavelDTO;
import br.com.mirante.eduapi.models.UsuarioResponsavel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioResponsavelMapper {
    UsuarioResponsavelMapper INSTANCE = Mappers.getMapper(UsuarioResponsavelMapper.class);
    UsuarioResponsavelDTO usuarioResponsavelToUsuarioResponsavelDTO(UsuarioResponsavel usuarioResponsavel);
    UsuarioResponsavel usuarioResponsavelDTOToUsuarioResponsavel(UsuarioResponsavelDTO usuarioResponsavelDTO);
}
