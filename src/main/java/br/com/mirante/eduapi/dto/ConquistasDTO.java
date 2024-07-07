package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConquistasDTO {
    private UUID id;
    private String nomdeDaConquista;
    private String descricao;
    private String meta;

    //alunoGetId
}
