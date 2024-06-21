package br.com.mirante.eduapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RankAluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "points")
    private String points;

    @Column(name = "img")
    private String img;

    @OneToMany(mappedBy = "aluno",cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_aluno")
    private List<Aluno> alunoList = new ArrayList<>();

}