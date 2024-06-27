package br.com.mirante.eduapi.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
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
}
