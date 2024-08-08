package br.com.mirante.eduapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoEloPost {
    private UUID id;
    private String pontuacaoDoAluno;
    private UUID alunoId;
    private UUID eloId;
}
