package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.*;
import br.com.mirante.eduapi.models.Aluno;
import br.com.mirante.eduapi.models.UsuarioResponsavel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper
public interface UsuarioResponsavelMapper {
    UsuarioResponsavelMapper INSTANCE = Mappers.getMapper(UsuarioResponsavelMapper.class);

    @Mapping(target = "alunos", source = "alunos")
    UsuarioResponsavelDTO usuarioResponsavelToUsuarioResponsavelDTO(UsuarioResponsavel usuarioResponsavelDTO);

    @Mapping(target = "alunos", source = "alunos")
    UsuarioResponsavel usuarioResponsavelDTOToUsuarioResponsavel(UsuarioResponsavelDTO usuarioResponsavel);

    @Mapping(source = "alunos", target = "alunoId", qualifiedByName = "alunoListToFirstId")
    UsuarioResponsavelDTOPost usuarioResponsavelToUsuarioResponsavelDTOPost(UsuarioResponsavel usuarioResponsavelDTO);

    @Mapping(target = "alunos", ignore = true)
    UsuarioResponsavel usuarioResponsavelDTOPostToUsuarioResponsavel(UsuarioResponsavelDTOPost usuarioResponsavelDTOPost);

    List<AlunoDTO> alunoListToAlunoDTOList(List<Aluno> alunos);

    List<Aluno> alunoDTOListToAlunoList(List<AlunoDTO> alunoDTOS);

    @Named("alunoListToFirstId")
    static UUID alunoListToFirstId(List<Aluno> alunos) {
        return alunos.isEmpty() ? null : alunos.get(0).getId();
    }
}
