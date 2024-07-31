package br.com.mirante.eduapi.controller;

import br.com.mirante.eduapi.dto.TurmaDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.TurmaMapper;
import br.com.mirante.eduapi.models.Turma;
import br.com.mirante.eduapi.service.TurmaService;
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
@RequestMapping(value = "/Turma")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar Turmas.", description = "Endpoint para consultar Turmas.", security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<TurmaDTO>> findAll(SpecTemplate.TurmaSpec spec, Pageable page){
        Page<Turma> consultaPage = turmaService.findAll(spec, page);
        if(consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(TurmaMapper.INSTANCE::ToturmaDTO), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(consultaPage.map(TurmaMapper.INSTANCE::ToturmaDTO), HttpStatus.OK);
        }
    }

    @PostMapping()
    @Operation(summary = "Cadastro de Turma.", description = "Endpoint para cadastrar Turma.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<TurmaDTO> create(@RequestBody TurmaDTO turmaDTO) throws BusinessException {
        TurmaDTO savedTurma = turmaService.save(turmaDTO);
        return ResponseEntity.ok(savedTurma);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Turma por ID.", description = "Endpoint para buscar a Turma pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<TurmaDTO> getById(@PathVariable UUID id) {
        return turmaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualização de Turma.", description = "Endpoint para atualizar os dados das turmas.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<TurmaDTO> update(@PathVariable UUID id, @RequestBody TurmaDTO turmaDTO) {
        return turmaService.update(id, turmaDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de Turma.", description = "Endpoint para remover uma Turma.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (turmaService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}
