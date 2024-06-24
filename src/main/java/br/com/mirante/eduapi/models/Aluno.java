package br.com.mirante.eduapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Aluno extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 7, name = "turma_aluno")
    private String turma;

    @ManyToOne
    @JoinColumn(name = "Id_usuario")
    private Usuario aluno;

    @ManyToOne
    @JoinColumn(name = "id_RankAluno")
    private RankAluno rankAluno ;

    @ManyToOne
    @JoinColumn(name = "Id_responsavel")
    private UsuarioResponsavel responsavel;

    @ManyToMany
    @JoinTable(
            name = "aluno_conquista",
            joinColumns = @JoinColumn(name = "id_aluno"),
            inverseJoinColumns = @JoinColumn(name = "id_conquista")
    )
    private List<Conquistas> conquistas = new ArrayList<>();

    @OneToMany(mappedBy = "aluno")
    private List<AlunosElo> alunosElo = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "alunoDisciplina")
    private List<Disciplina> disciplinas = new ArrayList<>();


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_serie")
    private Serie alunoSerie;



 /*   @OneToMany(mappedBy = "aluno")
    private List<RankGeral> ranksGeral;*/


    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }

}
