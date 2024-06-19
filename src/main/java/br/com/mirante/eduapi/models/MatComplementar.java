package br.com.mirante.eduapi.models;

import jakarta.persistence.*;

import java.util.UUID;

public class MatComplementar {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;

    @Column(name = "material", nullable = false, length = 100)
    private String material;

    //RELACIONAMENTO MAT_COMPLEMENTAR CONTEUDO
    @ManyToOne
    @JoinColumn(name = "id_conteudo", nullable = false)
    private Conteudo conteudo;
}
