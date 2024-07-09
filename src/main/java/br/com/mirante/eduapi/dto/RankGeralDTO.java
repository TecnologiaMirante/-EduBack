package br.com.mirante.eduapi.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public class RankGeralDTO {
    private UUID id;
    private String primeiro;
    private String segundo;
    private String terceiro;
}
