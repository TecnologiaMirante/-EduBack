
package br.com.mirante.eduapi.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Professor  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "materias", nullable = false, length = 100)
    private String materias;

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

    @Column(name = "avatarUrl", nullable = false, length = 100)
    private String avatar;

    @Column(name = "data_de_nascimento", nullable = false)
    private Date dataDeNascimento;

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

    @Column(name = "formacao", nullable = false, length = 100)
    private String formacao;

    @Column(name = "experiencia", nullable = false, length = 10)
    private String experiencia;


    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    //RELACIONAMENTO PROFESSOR DISCIPLINA
    @ManyToMany(mappedBy = "professorDisciplinaList")
    private List<Disciplina> disciplinaProfessorList = new ArrayList<>();

    //RELACIONAMENTO PROFESSOR CONTEUDO
    @OneToMany(mappedBy = "professorConteudo", cascade = CascadeType.ALL)
    private List<Conteudo> professorConteudoList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "Id_usuario")
    private Usuario usuarioProfessor;

    @ManyToOne
    @JoinColumn(name = "escola_id")
    private Escola professorEscola;

    @ManyToMany(mappedBy = "professorTurma")
    private List<Turma>turmasProfessor = new ArrayList<>();

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }

}
