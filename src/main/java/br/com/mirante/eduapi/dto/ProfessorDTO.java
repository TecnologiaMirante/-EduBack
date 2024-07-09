package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.controller.UsuarioDTOPost;
import br.com.mirante.eduapi.models.Turma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO extends UsuarioDTOPost {

    private String materiais;
    private String formacao;
    private String experiencia;
    private UUID usuarioId;

    private UUID turmaId;

    private UUID disciplinaId;

    //private List<Turma> turmas = new ArrayList<>();


    //role do keyclock
}
