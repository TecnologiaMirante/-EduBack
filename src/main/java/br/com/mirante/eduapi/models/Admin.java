package br.com.mirante.eduapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @ManyToOne
    @JoinColumn(name = "Id_usuario")
    private Usuario usuarioAdmin;

    @PrePersist
    public void generateUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }

}
