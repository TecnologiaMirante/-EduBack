package br.com.mirante.eduapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Escola {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;

    @Column(name = "estado", nullable = false, length = 2)
    private String estado;

    @Column(name = "cidade", nullable = false, length = 100)
    private String cidade;

    @Column(name = "bairro", nullable = false, length = 50)
    private String bairro;

    @Column(name = "numero", nullable = false, length = 5)
    private String numero;

    @Column(name = "logradouro", nullable = false, length = 150)
    private String logradouro;

    @Column(name = "complemento", length = 150)
    private String complemento;

    @Column(name = "cep", nullable = false, length = 15)
    private String cep;

    @Column(name = "referencia", nullable = false, length = 150)
    private String referencia;

    @Column(name = "cpfCnpj", nullable = false, length = 15)
    private String cpfCnpj;


    @OneToMany(mappedBy = "usuarioEscola", cascade = CascadeType.ALL)
    private List<Usuario> usuarios = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alunoEscola")
    private List<Aluno> alunos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professorEscola")
    private List<Professor>professores;

    @OneToMany(mappedBy = "escola",cascade = CascadeType.ALL)
    private List<RankAluno> rankAlunoList = new ArrayList<>();



    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }

}
