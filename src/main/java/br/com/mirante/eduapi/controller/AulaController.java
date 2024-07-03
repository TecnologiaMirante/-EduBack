package br.com.mirante.eduapi.controller;


import br.com.mirante.eduapi.dto.AulaDTO;
import br.com.mirante.eduapi.mappers.AulaMapper;
import br.com.mirante.eduapi.models.Aula;
import br.com.mirante.eduapi.service.AulaService;
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
@Tag(description = "Retorna Dados da Aula", name = "Aula")
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @GetMapping("/findAll")
    @Operation(summary = "Consulta Aulas.", description = "Endpoint para Consulta Aulas.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<AulaDTO>> findAll(SpecTemplate.AulaSpec spec, Pageable page) {
        Page<Aula> consultaPage = aulaService.findAll(spec, page);
        if (consultaPage.isEmpty()) {
            return new ResponseEntity<>(consultaPage.map(AulaMapper.INSTANCE::aulaToAulaDTO), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(consultaPage.map(AulaMapper.INSTANCE::aulaToAulaDTO), HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca Aulas por Id.", description = "Endpoint para Busca Aulas pelo Id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<AulaDTO> getById(@PathVariable UUID id) {
        return  aulaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
