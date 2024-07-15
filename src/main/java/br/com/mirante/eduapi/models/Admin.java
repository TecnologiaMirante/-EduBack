package br.com.mirante.eduapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Admin extends Usuario {


    @Enumerated(EnumType.STRING)
    private Permissoes permissoes;

    @ManyToOne
    @JoinColumn(name = "Id_usuario")
    private Usuario usuarioAdmin;


}
