package br.com.mirante.eduapi.controller;


import br.com.mirante.eduapi.dto.RankSerieDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.RankSerieMapper;
import br.com.mirante.eduapi.models.RankSerie;
import br.com.mirante.eduapi.service.RankSerieService;
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
@Tag(description = "Retorna os dados do ranking da série.", name = "Rank_Série")
@RequestMapping("/rankSerie")
public class RankSerieController {
    @Autowired
    private RankSerieService rankSerieService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar o ranking.", description = "Endpoint para consultar o ranking.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<RankSerieDTO>> findAll(SpecTemplate.RankSerieSpec spac, Pageable page){
        Page<RankSerie> consultaPage = rankSerieService.findAll(spac,page);
        if (consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(RankSerieMapper.INSTANCE::rankSerieToRankSerieDTO), HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(consultaPage.map(RankSerieMapper.INSTANCE::rankSerieToRankSerieDTO),HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    @Operation(summary = "Buscar o ranking por ID.", description = "Endpoint para buscar o ranking pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<RankSerieDTO> getById(@PathVariable UUID id){
        return rankSerieService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping()
    @Operation(summary = "Cadastro no ranking.", description = "Endpoint para cadastrar no  ranking.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<RankSerieDTO> create(@RequestBody RankSerieDTO rankSerieDTO ) throws BusinessException {
        RankSerieDTO savedRankSerie = rankSerieService.save(rankSerieDTO);
        return ResponseEntity.ok(savedRankSerie);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Atualização do Ranking.", description = "Endpoint para atualizar os dados do ranking.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<RankSerieDTO> update(@PathVariable UUID id , @RequestBody RankSerieDTO rankSerieDTO){
        return rankSerieService.update(id,rankSerieDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de ranking.", description = "Endpoint para remover uma pessoa do ranking.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        if (rankSerieService.deleteById(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();

    }
}
