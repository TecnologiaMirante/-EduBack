package br.com.mirante.eduapi.models;

import jakarta.persistence.*;

import java.util.UUID;

public class Nota_final {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private UUID id;

    //RELACIONAMENTO AVALIACAO NOTA
    @ManyToOne
    @JoinColumn(name = "id_avaliacao", nullable = false)
    private Avaliacao avaliacao;

    //RELACIONAMENTO DISCIPLINA NOTA
    @ManyToOne
    @JoinColumn(name = "id_disciplina", nullable = false)
    private Disciplina disciplina;

}
