package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Bimestre;
import br.com.mirante.eduapi.models.Disciplina;
import br.com.mirante.eduapi.models.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConteudoDTO {
    private String titulo;
    private String descricao;
    private UUID id_bimestre;
    private UUID id_disciplina;
    private UUID id_professor;
    private List<AulaDTOGet> aulas;
    private List<MaterialComplementarDTOget> materiais;
}
