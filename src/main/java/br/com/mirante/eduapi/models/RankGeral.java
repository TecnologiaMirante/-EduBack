package br.com.mirante.eduapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RankGeral {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "Primeiro_Lugar")
    private String primeiro;

    @Column(name = "Segundo_Lugar")
    private String segundo;

    @Column(name = "Terceiro_Lugar")
    private String terceiro;
}
