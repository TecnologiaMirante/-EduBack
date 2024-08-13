package br.com.mirante.eduapi.controller;


import br.com.mirante.eduapi.dto.RankAlunoDTO;
import br.com.mirante.eduapi.dto.RankAlunoGetDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.RankAlunoMapper;
import br.com.mirante.eduapi.models.RankAluno;
import br.com.mirante.eduapi.service.RankAlunoService;
import br.com.mirante.eduapi.specifications.SpecTemplate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(description = "Retorna os dados do ranking dos alunos.", name = "Rank_Aluno")
@RequestMapping("/rankAluno")
public class RankAlunoController {
    private RankAlunoService rankAlunoService;

    @PreAuthorize("hasAuthority(@AUTHORITIES.RANKALUNO_CONSULTAR)")
    @GetMapping("/findAll")
    @Operation(summary = "Consultar o ranking.", description = "Endpoint para consultar o ranking.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<RankAlunoGetDTO>> findAll(SpecTemplate.RankAlunoSpec spec, Pageable page) {
        Page<RankAluno> consultaPage = rankAlunoService.findAll(spec, page);
        if (consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(RankAlunoMapper.INSTANCE::rankAlunoToRankAlunoGEt),
                    HttpStatus.NOT_FOUND);
        }else{
            return  new ResponseEntity<>(consultaPage.map(RankAlunoMapper.INSTANCE::rankAlunoToRankAlunoGEt),HttpStatus.OK);
        }
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.RANKALUNO_CONSULTAR)")
    @GetMapping("/{id}")
    @Operation(summary = "Buscar o ranking por ID.", description = "Endpoint para buscar o ranking pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<RankAlunoDTO> getById(@PathVariable UUID id) {
        return rankAlunoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.RANKALUNO_CADASTRAR)")
    @PostMapping()
    @Operation(summary = "Cadastro no ranking.", description = "Endpoint para cadastrar no  ranking.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<RankAlunoDTO> create(@RequestBody RankAlunoDTO rankAlunoDTO) throws BusinessException {
        RankAlunoDTO savedRankAluno = rankAlunoService.save(rankAlunoDTO);
        return ResponseEntity.ok(savedRankAluno);
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.RANKALUNO_ATUALIZAR)")
    @PutMapping("/{id}")
    @Operation(summary = "Atualização do Ranking.", description = "Endpoint para atualizar os dados do ranking.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<RankAlunoDTO> update(@PathVariable UUID id ,@RequestBody RankAlunoDTO rankAlunoDTO){
        return  rankAlunoService.update(id, rankAlunoDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.RANKALUNO_DELETAR)")
    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de ranking.", description = "Endpoint para remover uma pessoa do ranking.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        if (rankAlunoService.deleteById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();

    }

}
