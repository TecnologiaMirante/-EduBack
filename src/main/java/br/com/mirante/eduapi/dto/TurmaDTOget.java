package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Serie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurmaDTOget {
    private UUID id;
    private String nome;
    private String turno;
    private String codigo;
    private Boolean status;


    //mudar turma para ser um atributo de serie
    //Relacionamento Serie

}