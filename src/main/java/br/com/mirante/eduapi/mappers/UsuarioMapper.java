package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.ProfessorDTOGet;
import br.com.mirante.eduapi.dto.UsuarioDTO;
import br.com.mirante.eduapi.models.Professor;
import br.com.mirante.eduapi.models.Usuario;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);
    Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO);


}
