package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.Media;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BimestreDTOpost {
    private UUID id;
    private UUID media_id;
    private UUID conteudo_id;
}