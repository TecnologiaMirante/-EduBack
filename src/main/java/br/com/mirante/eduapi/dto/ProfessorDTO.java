package br.com.mirante.eduapi.dto;


import br.com.mirante.eduapi.models.Turma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO {
    private UUID id;
    private String materiais;
    private String formacao;
    private String experiencia;

    //dto de turma
    //private List<Turma> turmas;

    //role do keyclock
}
