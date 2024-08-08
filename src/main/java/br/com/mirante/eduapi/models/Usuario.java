package br.com.mirante.eduapi.models;

import jakarta.persistence.*;
import jakarta.validation.OverridesAttribute;
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
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 50, name = "nome_usuario")
    private String nome;

    @Column(nullable = false, length = 70, unique = true)
    private String email;

    @Column(nullable = false, length = 20)
    private String senha;

    @Column(nullable = false, length = 36, unique = true)
    private String idKeycloak;

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
