package br.com.mirante.eduapi.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_Responsavel")
    private UsuarioResponsavel responsavel;

    @ManyToOne
    @JoinColumn(name = "id_Rank")
    private RankAluno rankAluno;

    @OneToMany(mappedBy = "Aula",cascade = CascadeType.ALL)
    private List<Aula> Aulalist = new ArrayList<>();

    @OneToMany(mappedBy = "aluno",cascade = CascadeType.ALL)
    private List<AlunoInteracao> alunoInteracaoList = new ArrayList<>();

}
