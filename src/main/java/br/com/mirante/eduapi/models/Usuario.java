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
@Table
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "nome", column = @Column(name = "nome", nullable = false, length = 150)),
            @AttributeOverride(name = "email", column = @Column(name = "email", nullable = false, length = 100)),
            @AttributeOverride(name = "telefone", column = @Column(name = "telefone", nullable = false, length = 15)),
            @AttributeOverride(name = "sexo", column =  @Column(name = "sexo", nullable = false, length = 10)),
            @AttributeOverride(name = "cpf", column = @Column(name = "cpf", nullable = false, length = 15)),
            @AttributeOverride(name = "matricula", column = @Column(name = "matricula", nullable = false, length = 50)),
            @AttributeOverride(name = "avatar", column =  @Column(name = "avatarUrl", nullable = false, length = 100)),
            @AttributeOverride(name = "dataDeNascimento", column = @Column(name = "data_de_nascimento", nullable = false)),
            @AttributeOverride(name = "status", column = @Column(name = "status", nullable = false, length = 10)),
            @AttributeOverride(name = "instagram", column = @Column(name = "instagram_url", nullable = false, length = 100)),
            @AttributeOverride(name = "facebook", column =  @Column(name = "facebook_url", nullable = false, length = 100)),
            @AttributeOverride(name = "whatsApp", column = @Column(name = "whatssapp_url", nullable = false, length = 100)),
            @AttributeOverride(name = "twitter", column =  @Column(name = "twitter_url", nullable = false, length = 100)),
            @AttributeOverride(name = "estado", column =  @Column(name = "estado", nullable = false, length = 50)),
            @AttributeOverride(name = "cidade", column = @Column(name = "cidade", nullable = false, length = 100)),
            @AttributeOverride(name = "bairro", column =  @Column(name = "bairro", nullable = false, length = 100)),
            @AttributeOverride(name = "numeroEndereco", column =  @Column(name = "numero_endereco", nullable = false, length = 10)),
            @AttributeOverride(name = "complemento", column =  @Column(name = "complemento", nullable = false, length = 100)),
            @AttributeOverride(name = "cep", column =  @Column(name = "cep", nullable = false, length = 15)),
            @AttributeOverride(name = "referencia", column = @Column(name = "referencia", nullable = false, length = 100))
    })
    private UserInfo userInfo;

    private Permissoes permissoes;

    @ManyToOne
    @JoinColumn(name = "id_escola")
    private Escola usuarioEscola;

    @OneToMany(mappedBy = "usuarioProfessor",cascade = CascadeType.ALL)
    private List<Professor> professorList = new ArrayList<>();

    @OneToMany(mappedBy = "usuarioAluno",cascade = CascadeType.ALL)
    private List<Aluno> alunoList = new ArrayList<>();

    @OneToMany(mappedBy = "usuarioAdmin",cascade = CascadeType.ALL)
    private List<Admin> adminList = new ArrayList<>();


    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
}