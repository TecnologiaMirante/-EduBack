package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisciplinaDTOpost {
    private UUID id;
    private String nome;
    private String codigo;
    private Boolean status;
    private UUID id_aluno;
    private UUID id_turma;
    private UUID id_professor;
    private UUID id_conteudo;
}