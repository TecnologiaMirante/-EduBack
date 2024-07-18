package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.ProfessorDTOGet;
import br.com.mirante.eduapi.dto.UsuarioDTO;
import br.com.mirante.eduapi.dto.UsuarioDTOPost;
import br.com.mirante.eduapi.models.Professor;
import br.com.mirante.eduapi.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(source = "usuarioEscola.id", target = "escola.id")
    @Mapping(source = "usuarioEscola", target = "escola")
  /*  @Mapping(source = "professorList", target = "professores")
    @Mapping(source = "alunoList", target = "alunos")*/
    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);

    List<UsuarioDTO> map(List<Usuario> usuarios);

    @Mapping(source = "escola.id", target = "usuarioEscola.id")
    @Mapping(source = "escola", target = "usuarioEscola")
 /*   @Mapping(source = "professores", target = "professorList")
    @Mapping(source = "alunos", target = "alunoList")*/
    Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO);

    @Mapping(source = "usuarioEscola.id", target = "escolaId")
    UsuarioDTOPost usuarioToUsuarioDTOPost(Usuario usuario);

    @Mapping(source = "escolaId", target = "usuarioEscola.id")
    Usuario usuarioDTOPostToUsuario(UsuarioDTOPost usuarioDTOPost);
}
