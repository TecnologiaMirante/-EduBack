package br.com.mirante.eduapi.controller;

import br.com.mirante.eduapi.dto.QuestoesDTO;
import br.com.mirante.eduapi.dto.RankTurmaDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.QuestoesMapper;
import br.com.mirante.eduapi.mappers.RankTurmaMapper;
import br.com.mirante.eduapi.models.Questoes;
import br.com.mirante.eduapi.models.RankTurma;
import br.com.mirante.eduapi.service.QuestoesService;
import br.com.mirante.eduapi.service.RankTurmaService;
import br.com.mirante.eduapi.specifications.SpecTemplate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(description = "Retorna os dados do ranking da turma.", name = "Rank_Turma")
@RequestMapping("/rankTurma")
public class RankTurmaController {
    @Autowired
    private RankTurmaService rankTurmaService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar o ranking.", description = "Endpoint para consultar o ranking.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<RankTurmaDTO>> findAll(SpecTemplate.RankTurmaSpec spac, Pageable page){
        Page<RankTurma> consultaPage = rankTurmaService.findAll(spac,page);
        if (consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(RankTurmaMapper.INSTANCE::rankTurmaToRankTurmaDTO), HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(consultaPage.map(RankTurmaMapper.INSTANCE::rankTurmaToRankTurmaDTO),HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    @Operation(summary = "Buscar o ranking por ID.", description = "Endpoint para buscar o ranking pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<RankTurmaDTO> getById(@PathVariable UUID id){
        return rankTurmaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping()
    @Operation(summary = "Cadastro no ranking.", description = "Endpoint para cadastrar no  ranking.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<RankTurmaDTO> create(@RequestBody RankTurmaDTO rankTurmaDTO ) throws BusinessException {
        RankTurmaDTO savedRankTurma = rankTurmaService.save(rankTurmaDTO);
        return ResponseEntity.ok(savedRankTurma);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Atualização do Ranking.", description = "Endpoint para atualizar os dados do ranking.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<RankTurmaDTO> update(@PathVariable UUID id , @RequestBody RankTurmaDTO rankTurmaDTO){
        return rankTurmaService.update(id,rankTurmaDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de ranking.", description = "Endpoint para remover uma pessoa do ranking.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        if (rankTurmaService.deleteById(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();

    }
}
