package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RankGeralDTO {
    private UUID id;
    private String primeiro;
    private String segundo;
    private String terceiro;
}
