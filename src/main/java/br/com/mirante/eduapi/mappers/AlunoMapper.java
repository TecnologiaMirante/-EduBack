package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.AlunoDTO;
import br.com.mirante.eduapi.dto.AlunoDTOPost;
import br.com.mirante.eduapi.dto.UsuarioDTO;
import br.com.mirante.eduapi.models.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface AlunoMapper {
    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    //@Mapping(source = "usuarioAluno.id", target = "usuarioId")
    //@Mapping(source = "usuarioAluno.usuarioEscola.id", target = "escolaId")
    @Mapping(source = "usuarioAluno.usuarioEscola", target = "escola")
    AlunoDTO alunoToAlunoDTO(Aluno aluno);


   // @Mapping(source = "usuarioId", target = "usuarioAluno.id")
    //@Mapping(source = "escolaId", target = "usuarioAluno.usuarioEscola.id")
    @Mapping(source = "escola", target = "usuarioAluno.usuarioEscola")
    Aluno alunoDTOToAluno(AlunoDTO aluno);

    @Mapping(source = "usuarioAluno.id", target = "usuarioId")
    @Mapping(source = "usuarioAluno.usuarioEscola.id", target = "escolaId")
    AlunoDTOPost alunoToAlunoPost(Aluno aluno);

    @Mapping(source = "usuarioId", target = "usuarioAluno.id")
    @Mapping(source = "escolaId", target = "usuarioAluno.usuarioEscola.id")
    Aluno alunoDTOPostToAluno(AlunoDTOPost aluno);

}
