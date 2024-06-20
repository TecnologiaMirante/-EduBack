package br.com.mirante.eduapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Elo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 100, name = "nome_elo")
    private String nome;

    @Column(nullable = false, length = 100, name = "pontuacao_elo")
    private double pontuação;

    @OneToMany
    private List<AlunosElo> eloDosAlunos = new ArrayList<>();


}
