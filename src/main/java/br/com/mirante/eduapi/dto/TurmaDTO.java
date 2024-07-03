package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurmaDTO {
    private UUID id;
    private String nome;
    private String turno;
    private String codigo;
    private Boolean status;

}
