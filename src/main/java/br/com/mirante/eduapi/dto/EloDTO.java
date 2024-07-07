package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EloDTO {
    private UUID id;
    private String nomeDoElo;
    private double pontuacao;

    //alunoEloGetId
}
