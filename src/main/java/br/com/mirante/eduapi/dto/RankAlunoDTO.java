package br.com.mirante.eduapi.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public class RankAlunoDTO {

    private UUID id;
    private String points;
    private String img;
}
