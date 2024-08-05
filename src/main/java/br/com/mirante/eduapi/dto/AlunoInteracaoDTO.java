package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoInteracaoDTO {
    private UUID id;
    private String anotar;
    private String anotacao;
    private String avaliar;
    private String comentario;
    private List<AulaDTO>  aula;
}
