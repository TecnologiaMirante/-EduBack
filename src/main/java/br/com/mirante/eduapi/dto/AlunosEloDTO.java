package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunosEloDTO {
    private UUID id;
    private String pontuacaoDoAluno;

    //id aluno
    //id elo
}
