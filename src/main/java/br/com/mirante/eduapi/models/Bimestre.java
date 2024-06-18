package br.com.mirante.eduapi.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bimestre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "data", nullable = false, length = 150)
    private String data;

    //RELACIONAMENTO BIMESTRE CONTEUDO
    @OneToMany(mappedBy = "Bimestre", cascade = CascadeType.ALL)
    private List<Conteudo> bimestreConteudoList = new ArrayList<>();

    //RELACIONAMENTO MEDIA BIMESTRE
    @OneToMany(mappedBy = "Bimestre", cascade = CascadeType.ALL)
    private List<Media> bimestreMediaList = new ArrayList<>();
}
