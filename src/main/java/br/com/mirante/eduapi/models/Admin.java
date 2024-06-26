package br.com.mirante.eduapi.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}

