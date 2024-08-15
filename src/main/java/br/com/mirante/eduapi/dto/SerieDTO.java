package br.com.mirante.eduapi.dto;

import br.com.mirante.eduapi.models.RankAluno;
import br.com.mirante.eduapi.models.RankSerie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SerieDTO {
    private UUID id;
    private String nome;
    private String turno;
    private List<TurmaDTOget> turmaSerie;
    private List<RankAlunoGetDTO> rankAluno;
    private List<AlunoDTOGet> aluno;
    //private List<RankSerieDTOget> rankserie;
}
