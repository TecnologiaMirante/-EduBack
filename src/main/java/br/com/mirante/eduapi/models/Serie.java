package br.com.mirante.eduapi.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "turno", nullable = false, length = 15)
    private String turno;

    //RELACIONAMENTO TURMA SERIE
    @OneToMany(mappedBy = "Serie", cascade = CascadeType.ALL)
    private List<Turma> turmaSerieList = new ArrayList<>();
}
