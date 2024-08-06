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

    @Mapping(target = "alunos", source = "alunos", qualifiedByName = "alunoListToUsuarioResponsavelDTOGetList")
    UsuarioResponsavelDTO usuarioResponsavelToUsuarioResponsavelDTO(UsuarioResponsavel usuarioResponsavelDTO);

    @Mapping(target = "alunos", source = "alunos", qualifiedByName = "usuarioResponsavelDTOGetListToAlunoList")
    UsuarioResponsavel usuarioResponsavelDTOToUsuarioResponsavel(UsuarioResponsavelDTO usuarioResponsavel);

    @Mapping(source = "alunos", target = "alunoId", qualifiedByName = "alunoListToFirstId")
    UsuarioResponsavelDTOPost usuarioResponsavelToUsuarioResponsavelDTOPost(UsuarioResponsavel usuarioResponsavelDTO);

    @Mapping(source = "alunoId", target = "alunos", qualifiedByName = "idToSingleAlunoList")
    UsuarioResponsavel usuarioResponsavelDTOPostToUsuarioResponsavel(UsuarioResponsavelDTOPost usuarioResponsavelDTOPost);

    @Named("alunoListToUsuarioResponsavelDTOGetList")
    static List<UsuarioResponsavelDTOGet> alunoListToUsuarioResponsavelDTOGetList(List<Aluno> alunos) {
        return alunos.stream()
                .map(aluno -> new UsuarioResponsavelDTOGet(aluno.getId()))
                .collect(Collectors.toList());
    }

    @Named("usuarioResponsavelDTOGetListToAlunoList")
    static List<Aluno> usuarioResponsavelDTOGetListToAlunoList(List<UsuarioResponsavelDTOGet> dtoGetList) {
        return dtoGetList.stream()
                .map(dto -> {
                    Aluno aluno = new Aluno();
                    aluno.setId(dto.getId());
                    return aluno;
                })
                .collect(Collectors.toList());
    }

    @Named("alunoListToFirstId")
    static UUID alunoListToFirstId(List<Aluno> alunos) {
        return alunos.isEmpty() ? null : alunos.get(0).getId();
    }

    @Named("idToSingleAlunoList")
    static List<Aluno> idToSingleAlunoList(UUID id) {
        Aluno aluno = new Aluno();
        aluno.setId(id);
        return List.of(aluno);
    }
}
