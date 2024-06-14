package br.com.mirante.eduapi.controller;

import br.com.mirante.eduapi.dto.EscolaDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.EscolaMapper;
import br.com.mirante.eduapi.models.Escola;
import br.com.mirante.eduapi.service.EscolaService;
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
@Tag(description = "Retorna Dados das Escolas", name = "Escola")
@RequestMapping("/escola")
public class EscolaController {

    @Autowired
    private EscolaService escolaService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar Escolas.", description = "Endpoint para consultar Escolas.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<EscolaDTO>> findAll(SpecTemplate.EscolaSpec spec, Pageable page) {
        Page<Escola> consultaPage = escolaService.findAll(spec, page);
        if (consultaPage.isEmpty()) {
            return new ResponseEntity<>(consultaPage.map(EscolaMapper.INSTANCE::escolaToEscolaDTO), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(consultaPage.map(EscolaMapper.INSTANCE::escolaToEscolaDTO), HttpStatus.OK);
        }
    }

    @PostMapping()
    @Operation(summary = "Cadastro de Escola.", description = "Endpoint para cadastrar Escolas.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<EscolaDTO> create(@RequestBody EscolaDTO escolaDTO) throws BusinessException {
        EscolaDTO savedEscola = escolaService.save(escolaDTO);
        return ResponseEntity.ok(savedEscola);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Escola por ID.", description = "Endpoint para buscar a escolas pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<EscolaDTO> getById(@PathVariable UUID id) {
        return escolaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualização de Escola.", description = "Endpoint para atualizar os dados das escolas.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<EscolaDTO> update(@PathVariable UUID id, @RequestBody EscolaDTO escolaDTO) {
        return escolaService.update(id, escolaDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de Escola.", description = "Endpoint para remover uma escola.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (escolaService.deleteById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }

}
