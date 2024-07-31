package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Conteudo;
import br.com.mirante.eduapi.models.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoDTO {
    private String nota;
    private String data;
    private String descricao;
    private char tipo;
    private UUID id_conteudo;
    private UUID id_professor;
    //IMG
}
