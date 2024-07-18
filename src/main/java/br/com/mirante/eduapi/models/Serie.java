package br.com.mirante.eduapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "turno", nullable = false, length = 15)
    private String turno;

    //RELACIONAMENTO TURMA SERIE
    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
    private List<Turma> turmaSerieList = new ArrayList<>();

    @OneToMany(mappedBy = "alunoSerie")
    private List<Aluno> serieAluno = new ArrayList<>();


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Serie_RankSerie",
            joinColumns = @JoinColumn(name = "id_Serie"),
            inverseJoinColumns = @JoinColumn(name = "id_RankSerie"))
    private List<RankSerie> RankSerieList;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Serie_RankAluno",
            joinColumns = @JoinColumn(name = "id_Serie"),
            inverseJoinColumns = @JoinColumn(name = "id_RankAluno")
    )
    private List<RankAluno> RankAlunoSerieList;


    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}