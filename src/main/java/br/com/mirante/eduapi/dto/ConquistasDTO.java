package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConquistasDTO {
    private UUID id;
    private String nomdeDaConquista;
    private String descricao;
    private String meta;

    //Alunos que possuem essa conquista
    private List<AlunoConquistaDTO> alunos;
}
