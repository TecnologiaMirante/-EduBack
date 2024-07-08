package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoDTO {
    private UUID id;
    private String nota;
    private String data;
    private String descricao;
    private char tipo;
    // IMG
    //RELACIONAMENTOS ID CONTEUDO E ID PROFESSOR
}
