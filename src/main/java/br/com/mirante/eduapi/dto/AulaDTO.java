package br.com.mirante.eduapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AulaDTO {
    private UUID id;
    private String titulo;
    private String descricao;
    private String link;
    private String arquivo;
    private String avaliacao;
    private String img;
    private Date data;
    private Boolean favoritar;
    private Boolean conteudoRealizado;
    private UUID IdAluno;
    private List<AlunoInteracaoDTO> alunointeracoe;
}
