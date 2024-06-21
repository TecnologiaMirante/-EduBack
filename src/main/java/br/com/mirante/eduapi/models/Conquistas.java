package br.com.mirante.eduapi.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Conquistas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 70, name = "nome_conquista")
    private String nome;

    @Column(nullable = false, length = 100, name = "descricao_conquista")
    private String descricao;

    @Column(nullable = false, length = 70, name = "meta")
    private String meta;

    @ManyToMany(mappedBy = "conquistas", cascade = CascadeType.ALL)
    private List<Aluno> alunos = new ArrayList<>();

}