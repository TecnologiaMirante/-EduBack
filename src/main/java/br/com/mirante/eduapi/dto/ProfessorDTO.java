package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Professor;
import br.com.mirante.eduapi.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO extends UsuarioDTOPost {

    private String materias;
    private String formacao;
    private String experiencia;
    private UUID usuarioId;
    private UUID turmaId;

    private UUID disciplinaId;

    //private List<Turma> turmas = new ArrayList<>();

    public ProfessorDTO(Professor entity) {
        Usuario usuario = new Usuario();
        usuarioId = entity.getUsuarioProfessor().getId();

    }


    //role do keyclock
}
