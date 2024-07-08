package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.AlunoInteracaoDTO;
import br.com.mirante.eduapi.models.AlunoInteracao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlunoInteracaoMapper {
    AlunoInteracaoMapper INSTANCE = Mappers.getMapper(AlunoInteracaoMapper.class);
    AlunoInteracaoDTO alunoInteracaoToAlunoInteracaoDTO(AlunoInteracao aluno);
    AlunoInteracao alunoInteracaoDTOToAlunoInteracao(AlunoInteracaoDTO dto);
}
