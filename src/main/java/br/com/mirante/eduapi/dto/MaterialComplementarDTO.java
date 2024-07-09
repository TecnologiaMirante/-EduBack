package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Conteudo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialComplementarDTO {
    private UUID id;
    private String titulo;
    private String material; // MUDAR ARQUIVO
    private Conteudo conteudo;
}
