package br.com.mirante.eduapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;

    @Column(name = "sexo", nullable = false, length = 10)
    private String sexo;

    @Column(name = "cpf", nullable = false, length = 15)
    private String cpf;

    @Column(name = "matricula", nullable = false, length = 50)
    private String matricula;

    @Column(name = "avatar_url", nullable = false, length = 100)
    private String avatar;

    @Column(name = "data_de_nascimento", nullable = false)
    private LocalDateTime dataDeNascimento;

    @Column(name = "status", nullable = false, length = 10)
    private String status;

    @Column(name = "instagram_url", nullable = false, length = 100)
    private  String instagram;

    @Column(name = "facebook_url", nullable = false, length = 100)
    private  String facebook;

    @Column(name = "whatssapp_url", nullable = false, length = 100)
    private  String whatsApp;

    @Column(name = "twitter_url", nullable = false, length = 100)
    private  String twitter;

    @Column(name = "estado", nullable = false, length = 50)
    private  String estado;

    @Column(name = "cidade", nullable = false, length = 100)
    private  String cidade;

    @Column(name = "bairro", nullable = false, length = 100)
    private  String  bairro;

    @Column(name = "numero_endereco", nullable = false, length = 10)
    private  String  numeroEndereco;

    @Column(name = "complemento", nullable = false, length = 100)
    private  String  complemento;

    @Column(name = "cep", nullable = false, length = 15)
    private  String cep;

    @Column(name = "referencia", nullable = false, length = 100)
    private  String referencia;

    @Enumerated(EnumType.STRING)
    private Permissoes permissoes;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turmaAluno;

    @ManyToOne
    @JoinColumn(name = "Id_usuario")
    private Usuario usuarioAluno;

    @ManyToOne
    @JoinColumn(name = "id_escola")
    private Escola alunoEscola;

    /*@OneToMany(mappedBy = "aluno",cascade = CascadeType.ALL)
    private List<RankAluno> rankAluno =  new ArrayList<>();*/

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
