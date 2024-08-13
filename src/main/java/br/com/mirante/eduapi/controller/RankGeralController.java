package br.com.mirante.eduapi.controller;


import br.com.mirante.eduapi.dto.RankGeralDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.RankGeralMapper;
import br.com.mirante.eduapi.models.RankGeral;
import br.com.mirante.eduapi.service.RankGeralService;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(description = "Retorna os dados do ranking da escola.", name = "Rank_Escola")
@RequestMapping("/rankEscola")
public class RankGeralController {
    @Autowired
    private RankGeralService rankGeralService;

    @PreAuthorize("hasAuthority(@AUTHORITIES.RANKGERAL_CONSULTAR)")
    @GetMapping("/findAll")
    @Operation(summary = "Consultar o ranking.", description = "Endpoint para consultar o ranking.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<RankGeralDTO>> findAll(SpecTemplate.RankGeralSpec spac, Pageable page){
        Page<RankGeral> consultaPage = rankGeralService.findAll(spac,page);
        if (consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(RankGeralMapper.INSTANCE::rankGeralToRankGeralDTO), HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(consultaPage.map(RankGeralMapper.INSTANCE::rankGeralToRankGeralDTO),HttpStatus.OK);
        }
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.RANKGERAL_CONSULTAR)")
    @GetMapping("/{id}")
    @Operation(summary = "Buscar o ranking por ID.", description = "Endpoint para buscar o ranking pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<RankGeralDTO> getById(@PathVariable UUID id){
        return rankGeralService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.RANKGERAL_CADASTRAR)")
    @PostMapping()
    @Operation(summary = "Cadastro no ranking.", description = "Endpoint para cadastrar no  ranking.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<RankGeralDTO> create(@RequestBody RankGeralDTO rankGeralDTO ) throws BusinessException {
        RankGeralDTO savedRankGeral = rankGeralService.save(rankGeralDTO);
        return ResponseEntity.ok(savedRankGeral);
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.RANKGERAL_ATUALIZAR)")
    @PutMapping("/{id}")
    @Operation(summary = "Atualização do Ranking.", description = "Endpoint para atualizar os dados do ranking.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<RankGeralDTO> update(@PathVariable UUID id , @RequestBody RankGeralDTO rankGeralDTO){
        return rankGeralService.update(id,rankGeralDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.RANKGERAL_DELETAR)")
    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de ranking.", description = "Endpoint para remover uma pessoa do ranking.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        if (rankGeralService.deleteById(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();

    }
}
