package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.UsuarioDTO;
import br.com.mirante.eduapi.dto.UsuarioDTOPost;
import br.com.mirante.eduapi.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(source = "usuarioEscola.id", target = "escola.id")
    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);
    @Mapping(source = "escola.id", target = "usuarioEscola.id")
    Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO);

    @Mapping(source = "usuarioEscola.id", target = "escolaId")
    UsuarioDTOPost usuarioToUsuarioDTOPost(Usuario usuario);
    //@Mapping(source = "escolaId", target = "usuarioEscola.id")
    Usuario usuarioDTOPostToUsuario(UsuarioDTOPost usuarioDTOPost);
}
