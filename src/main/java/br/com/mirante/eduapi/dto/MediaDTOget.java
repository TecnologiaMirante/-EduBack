package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Aluno;
import br.com.mirante.eduapi.models.Bimestre;
import br.com.mirante.eduapi.models.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaDTOget {
    private UUID id;
    private String nota;
    private Disciplina disciplina;
    private Aluno aluno;
}
