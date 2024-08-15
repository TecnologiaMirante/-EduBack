package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SerieDTOpost{
    private UUID id;
    private String nome;
    private String turno;
    private UUID id_turma;
    private UUID id_aluno;
    private UUID id_rankAluno;
    //private UUID id_rankSerie;
}