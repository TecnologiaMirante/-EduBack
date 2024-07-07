package br.com.mirante.eduapi.controller;

import br.com.mirante.eduapi.dto.EloDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.EloMapper;
import br.com.mirante.eduapi.models.Elo;
import br.com.mirante.eduapi.service.EloService;
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
@Tag(description = "Retorna Dados dos elos", name = "elos")
@RequestMapping("/elo")
public class EloController {
    @Autowired
    private EloService eloService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar os elos.", description = "Endpoint para consultar os elos.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<EloDTO>> findAll(SpecTemplate.EloSpec spec, Pageable page) {
        Page<Elo> consultaPage = eloService.findAll(spec, page);
        if (consultaPage.isEmpty()) {
            return new ResponseEntity<>(consultaPage.map(EloMapper.INSTANCE::eloToDTO), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(consultaPage.map(EloMapper.INSTANCE::eloToDTO), HttpStatus.OK);
        }
    }

    @PostMapping("/")
    @Operation(summary = "Cadastro de elos.", description = "Endpoint para cadastrar elos.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<EloDTO> create(@RequestBody EloDTO eloDTO) throws BusinessException {
        EloDTO savedElo = eloService.save(eloDTO);
        return ResponseEntity.ok(savedElo);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar elo por ID.", description = "Endpoint para buscar o elo pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<EloDTO> getById(@PathVariable UUID id) {
        return eloService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualização de elo.", description = "Endpoint para atualizar os dados dos elos.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<EloDTO> update(@PathVariable UUID id, @RequestBody EloDTO eloDTO) {
        return eloService.update(id, eloDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de elos.", description = "Endpoint para remover um elo.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (eloService.deleteById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }

}
