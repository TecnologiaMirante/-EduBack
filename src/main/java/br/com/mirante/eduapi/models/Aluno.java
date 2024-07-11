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

    @Enumerated(EnumType.STRING)
    private Permissoes permissoes;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turmaAluno;

    @ManyToOne
    @JoinColumn(name = "Id_usuario")
    private Usuario usuarioAluno;

    @ManyToOne
    @JoinColumn(name = "id_RankAluno")
    private RankAluno rankAluno ;

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



 /*   @OneToMany(mappedBy = "aluno")
    private List<RankGeral> ranksGeral;*/


}
