package br.com.mirante.eduapi.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestoesDTO {
    private UUID id;
    private String titulo;
    private String descricao;
    private List<OpcoesDTO> idOpcoes;
    private UUID idAvaliacao;
//    private List<ConteudoDTO> conteudo;
}
