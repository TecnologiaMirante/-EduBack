package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.AlunoDTO;
import br.com.mirante.eduapi.dto.AlunoDTOPost;
import br.com.mirante.eduapi.dto.EscolaUsuarioDTO;
import br.com.mirante.eduapi.dto.UsuarioDTO;
import br.com.mirante.eduapi.models.Aluno;
import br.com.mirante.eduapi.models.Escola;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface AlunoMapper {
    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    @Mappings({
            @Mapping(source = "usuarioAluno.usuarioEscola", target = "escola"),
    })
    AlunoDTO alunoToAlunoDTO(Aluno aluno);

    @Mappings({
            @Mapping(source = "usuarioAluno.alunoList", target = "usuarioList"),
            @Mapping(source = "userInfo.nome", target = "nome"),
            @Mapping(source = "userInfo.email", target = "email"),
            @Mapping(source = "userInfo.cidade", target = "cidade"),
            @Mapping(source = "userInfo.estado", target = "estado"),
            @Mapping(source = "userInfo.telefone", target = "telefone"),
            @Mapping(source = "userInfo.cpf", target = "cpfCnpj"),

    })
    Escola usuarioAlunoToEscola(Aluno aluno);

    List<Escola> usuarioAlunoToEscola(List<Aluno> alunos);


    @Mappings({
            @Mapping(source = "escola", target = "usuarioAluno.usuarioEscola")
    })
    Aluno alunoDTOToAluno(AlunoDTO aluno);

    @Mappings({
            @Mapping(source = "usuarioAluno.id", target = "usuarioId"),
            @Mapping(source = "usuarioAluno.usuarioEscola.id", target = "escolaId"),
            //@Mapping(source = "userInfo", target = "userInfo")
    })
    AlunoDTOPost alunoToAlunoPost(Aluno aluno);

    @Mappings({
            @Mapping(source = "usuarioId", target = "usuarioAluno.id"),
            @Mapping(source = "escolaId", target = "usuarioAluno.usuarioEscola.id")
    })
    Aluno alunoDTOPostToAluno(AlunoDTOPost aluno);

}
