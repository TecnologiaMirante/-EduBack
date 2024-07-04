package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaDTO {
    private UUID id;
    private String nota;
    //Relacionamento Disciplina e Aluno
}
