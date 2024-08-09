package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.*;
import br.com.mirante.eduapi.models.Aluno;
import br.com.mirante.eduapi.models.Conquistas;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper
public interface ConquistaMapper {
    ConquistaMapper INSTANCE = Mappers.getMapper(ConquistaMapper.class);

    @Mapping(source = "nome", target = "nomdeDaConquista")
    @Mapping(source = "alunos", target = "alunos")
    ConquistasDTO conquistasToDTO(Conquistas conquistas);

    @Mapping(target = "nome", source = "nomdeDaConquista")
    @Mapping(source = "alunos", target = "alunos")
    Conquistas DTOtoConquistas(ConquistasDTO conquistasDTO);

    @Mapping(source = "alunos", target = "alunoId", qualifiedByName =
            "alunoListToFirstId")
    @Mapping(target = "nomdeDaConquista", source = "nome")
     ConquistaDTOPost conquistasToDTOPost(Conquistas conquistas);

    @Mapping(target = "nome", source = "nomdeDaConquista")
    @Mapping(target = "alunos", ignore = true)
     Conquistas conquistasDTOPostToConquistas(ConquistaDTOPost conquistas);

    List<AlunoConquistaDTO>alunoConquistaDTOListToAluno(List<Aluno> alunos);

    List<Aluno>alunoListToAlunoConquistaDTOlist(List<AlunoConquistaDTO> alunoDTOS);

    @Named("alunoListToFirstId")
    static UUID alunoListToFirstId(List<Aluno> alunos) {
        return alunos.isEmpty() ? null : alunos.get(0).getId();
    }
}
