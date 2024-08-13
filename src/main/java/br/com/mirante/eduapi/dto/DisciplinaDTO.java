package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Conteudo;
import br.com.mirante.eduapi.models.Professor;
import br.com.mirante.eduapi.models.Turma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisciplinaDTO {
    private UUID id;
    private String nome;
    private String codigo;
    private Boolean status;
    private ProfessorDTOGet profDisciplina;
    private TurmaDTOget turmaDisciplina;
    private ConteudoDTOget conteudoDisciplina;
}
