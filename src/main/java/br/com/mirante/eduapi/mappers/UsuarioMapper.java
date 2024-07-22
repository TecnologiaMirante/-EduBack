package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.*;
import br.com.mirante.eduapi.models.Aluno;
import br.com.mirante.eduapi.models.Professor;
import br.com.mirante.eduapi.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mappings({
            @Mapping(source = "usuarioEscola.id", target = "escola.id"),
            @Mapping(source = "usuarioEscola", target = "escola")
    })
    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);

    List<UsuarioDTO> map(List<Usuario> usuarios);

    @Mapping(source = "usuarioAluno.usuarioEscola", target = "escola")
    AlunoDTO map(Aluno aluno);

   /* @Mapping(source = "")
    ProfessorDTO map(Professor professor);*/

    @Mappings({
            @Mapping(source = "escola.id", target = "usuarioEscola.id"),
            @Mapping(source = "escola", target = "usuarioEscola")
    })
    Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO);

    @Mapping(source = "usuarioEscola.id", target = "escolaId")
    UsuarioDTOPost usuarioToUsuarioDTOPost(Usuario usuario);

    @Mapping(source = "escolaId", target = "usuarioEscola.id")
    Usuario usuarioDTOPostToUsuario(UsuarioDTOPost usuarioDTOPost);
}
