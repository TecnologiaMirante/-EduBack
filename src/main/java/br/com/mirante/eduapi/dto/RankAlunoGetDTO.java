package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RankAlunoGetDTO {
    private UUID id;
    private Integer points;
    private String img;
    private String apelido;
}
