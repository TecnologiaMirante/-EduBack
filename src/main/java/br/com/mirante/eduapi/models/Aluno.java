package br.com.mirante.eduapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Aluno  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Embedded
    private UserInfo userInfo;

    @Enumerated(EnumType.STRING)
    private Permissoes permissoes = Permissoes.ALUNO;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turmaAluno;

    @ManyToOne
    @JoinColumn(name = "Id_usuario")
    private Usuario usuarioAluno;

    @ManyToOne
    @JoinColumn(name = "id_escola")
    private Escola alunoEscola;

    @ManyToOne
    @JoinColumn(name = "id_RankAluno")
    private RankAluno rankAluno;

    @ManyToOne
    @JoinColumn(name = "Id_responsavel")
    private UsuarioResponsavel responsavelAluno;

    @ManyToMany
    @JoinTable(
            name = "aluno_conquista",
            joinColumns = @JoinColumn(name = "id_aluno"),
            inverseJoinColumns = @JoinColumn(name = "id_conquista")
    )
    private List<Conquistas> conquistas = new ArrayList<>();

    @OneToMany(mappedBy = "alunoElo", cascade = CascadeType.ALL)
    private List<AlunosElo> alunosElo = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "alunoDisciplina")
    private List<Disciplina> disciplinasAlunos = new ArrayList<>();


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_serie")
    private Serie alunoSerie;

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }


 /*   @OneToMany(mappedBy = "aluno")
    private List<RankGeral> ranksGeral;*/


}
