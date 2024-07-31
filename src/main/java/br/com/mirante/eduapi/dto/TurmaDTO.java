package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurmaDTO {
    private String nome;
    private String turno;
    private String codigo;
    private Boolean status;
    private UUID id_serie;

    //mudar turma para ser um atributo de serie
    //Relacionamento Serie

}
