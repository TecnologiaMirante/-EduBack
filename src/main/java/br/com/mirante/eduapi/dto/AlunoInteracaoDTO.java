package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoInteracaoDTO {
    private String anotacao;
    private String avaliar;
    private String comentario;
    private List<AulaDTO> aulas;
}
