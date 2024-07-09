package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Bimestre;
import br.com.mirante.eduapi.models.Disciplina;
import br.com.mirante.eduapi.models.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConteudoDTO {
    private UUID id;
    private String titulo;
    private String descricao;
    private Disciplina disciplina;
    private Professor professor;
    private Bimestre bimestre;
}
