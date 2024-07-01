package br.com.mirante.eduapi.dto;


import br.com.mirante.eduapi.models.Turma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO {

    private String materiais;
    private String formacao;
    private String experiencia;
    private List<Turma> turmas;

    //role do keyclock
}
