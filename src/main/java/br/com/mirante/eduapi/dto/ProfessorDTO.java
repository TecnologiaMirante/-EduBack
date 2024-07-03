package br.com.mirante.eduapi.dto;

import jakarta.persistence.Column;

import java.util.UUID;

public class ProfessorDTO {
    private UUID id;
    private String turmas;
    private String materias;
    private String formacao;
    private String experiencia;
}
