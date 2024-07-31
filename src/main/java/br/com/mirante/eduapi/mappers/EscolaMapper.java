package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.AlunoDTO;
import br.com.mirante.eduapi.dto.AlunoDTOGet;
import br.com.mirante.eduapi.models.Aluno;
import br.com.mirante.eduapi.models.Escola;
import br.com.mirante.eduapi.dto.EscolaDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface EscolaMapper {
    EscolaMapper INSTANCE = Mappers.getMapper(EscolaMapper.class);

    EscolaDTO escolaToEscolaDTO(Escola escola);

    List<EscolaDTO> map(List<Escola> escola);

    Escola escolaDTOToEscola(EscolaDTO escolaDTO);

    @Mapping(source = "usuarioAluno.id", target = "usuarioId")
    AlunoDTOGet alunoToAlunoDTOGet(Aluno aluno);

    @Mapping(source = "usuarioId", target = "usuarioAluno.id")
    Aluno alunoDTOGetToAluno(AlunoDTOGet aluno);

}
