package br.com.mirante.eduapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuariosDTOGetAll {

    private List<ProfessorDTOGet> professores;
    //private List<AdminDTO> admins
    private List<AlunoDTO> alunos;
}
