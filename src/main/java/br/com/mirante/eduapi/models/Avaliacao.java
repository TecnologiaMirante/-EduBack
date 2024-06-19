package br.com.mirante.eduapi.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "nota", nullable = false, length = 150)
    private String nota;

    @Column(name = "data", nullable = false, length = 150)
    private String data;

    @Column(name = "descricao", nullable = false, length = 100)
    private String descricao;

    @Column(name = "tipo", nullable = false, length = 150)
    private char tipo;

    @Column(name = "img", nullable = false, length = 150)
    private String img;

    //RELACIONAMENTO AVALIACAO CONTEUDO
    @OneToMany(mappedBy = "avaliacao", cascade = CascadeType.ALL)
    private List<Conteudo> avaliacaoConteudoList = new ArrayList<>();

    //RELACIONAMENTO AVALIACAO NOTA
    @OneToMany(mappedBy = "avaliacao", cascade = CascadeType.ALL)
    private List<Nota_final> notaAvaliacaoList = new ArrayList<>();

    //RELACIONAMENTO AVALIACAO QUESTOES
    @OneToMany(mappedBy = "avaliacao", cascade = CascadeType.ALL)
    private List<Questoes> questoesAvaliacaoList = new ArrayList<>();

}
