package br.com.mirante.eduapi.controller;

import br.com.mirante.eduapi.dto.AvaliacaoDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.AvaliacaoMapper;
import br.com.mirante.eduapi.models.Avaliacao;
import br.com.mirante.eduapi.service.AvaliacaoService;
import br.com.mirante.eduapi.specifications.SpecTemplate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/Avaliacao")
public class AvaliacaoController {
    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar Avaliacoes.", description = "Endpoint para consultar avaliacoes.", security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<AvaliacaoDTO>> findAll(SpecTemplate.AvaliacaoSpec spec, Pageable page){
        Page<Avaliacao> consultaPage = avaliacaoService.findAll(spec, page);
        if(consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(AvaliacaoMapper.INSTANCE::ToAvaliacaoDTO), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(consultaPage.map(AvaliacaoMapper.INSTANCE::ToAvaliacaoDTO), HttpStatus.OK);
        }
    }

    @PostMapping()
    @Operation(summary = "Cadastro de Avaliacao.", description = "Endpoint para cadastrar Avaliacao.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<AvaliacaoDTO> create(@RequestBody AvaliacaoDTO avaliacaoDTO) throws BusinessException {
        AvaliacaoDTO savedAvaliacao = avaliacaoService.save(avaliacaoDTO);
        return ResponseEntity.ok(savedAvaliacao);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Avaliacao por ID.", description = "Endpoint para buscar a Avaliacao pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<AvaliacaoDTO> getById(@PathVariable UUID id) {
        return avaliacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualização de Avaliacao.", description = "Endpoint para atualizar os dados das avaliacoes.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<AvaliacaoDTO> update(@PathVariable UUID id, @RequestBody AvaliacaoDTO avaliacaoDTO) {
        return avaliacaoService.update(id, avaliacaoDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de Avaliacao.", description = "Endpoint para remover uma Avaliacao.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (avaliacaoService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }

}
