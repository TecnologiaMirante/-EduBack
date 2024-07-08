package br.com.mirante.eduapi.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpcoesDTO {
    private UUID id;
    private String nota;
    private Boolean correto;
}
