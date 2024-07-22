package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.AlunoDTO;
import br.com.mirante.eduapi.dto.AlunoDTOGet;
import br.com.mirante.eduapi.dto.UsuarioDTO;
import br.com.mirante.eduapi.models.Aluno;
import br.com.mirante.eduapi.models.Escola;
import br.com.mirante.eduapi.dto.EscolaDTO;
import br.com.mirante.eduapi.models.Usuario;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EscolaMapper {
    EscolaMapper INSTANCE = Mappers.getMapper(EscolaMapper.class);

    EscolaDTO escolaToEscolaDTO(Escola escola);

    List<EscolaDTO> map(List<Escola> escola);

    @Mapping(source = "usuarioList", target = "usuarioList")
    Escola escolaDTOToEscola(EscolaDTO escolaDTO);

    default Aluno map(AlunoDTO alunoDTO, @Context Escola escola) {
        Aluno aluno = new Aluno();
        aluno.setId(alunoDTO.getId());
        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setCpf(alunoDTO.getCpf());

        escola.getUsuarioList().add(aluno);

        return aluno;

    }
}
