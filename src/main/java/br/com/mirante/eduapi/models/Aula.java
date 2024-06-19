package br.com.mirante.eduapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "link", nullable = false)
    private String link;

    @Column(name = "arquivo", nullable = false)
    private String arquivo;

    @Column(name = "titulo", nullable = false)
    private String avaliacao;

    @Column(name = "img", nullable = false)
    private String img;

    @Column(name = "data", nullable = false , length = 8)
    private Date data;

    @Column(name = "favoritar", nullable = false)
    private Boolean favoritar;

    @Column(name = "conteudo_realizado", nullable = false)
    private Boolean conteudoRealizado;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    @ManyToMany
    @JoinTable(name = "Aula_Interacao",
            joinColumns = @JoinColumn(name = "id_aula"),
            inverseJoinColumns = @JoinColumn(name = "id_interacao"))
    private List<AlunoInteracao> alunoInteracaos = new ArrayList<>();
}
