package br.com.mirante.eduapi.controller;

import br.com.mirante.eduapi.dto.DisciplinaDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.DisciplinaMapper;
import br.com.mirante.eduapi.models.Disciplina;
import br.com.mirante.eduapi.service.DisciplinaService;
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
@RequestMapping(value = "/Disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar Disciplinas.", description = "Endpoint para consultar disciplinas.", security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<DisciplinaDTO>> findAll(SpecTemplate.DisciplinaSpec spec, Pageable page){
        Page<Disciplina> consultaPage = disciplinaService.findAll(spec, page);
        if(consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(DisciplinaMapper.INSTANCE::ToDisciplinaDTO), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(consultaPage.map(DisciplinaMapper.INSTANCE::ToDisciplinaDTO), HttpStatus.OK);
        }
    }

    @PostMapping()
    @Operation(summary = "Cadastro de Disciplina.", description = "Endpoint para cadastrar Disciplina.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<DisciplinaDTO> create(@RequestBody DisciplinaDTO disciplinaDTO) throws BusinessException {
        DisciplinaDTO savedDisciplina = disciplinaService.save(disciplinaDTO);
        return ResponseEntity.ok(savedDisciplina);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Disciplina por ID.", description = "Endpoint para buscar a Disciplina pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<DisciplinaDTO> getById(@PathVariable UUID id) {
        return disciplinaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualização de Disciplina.", description = "Endpoint para atualizar os dados das disciplinas.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<DisciplinaDTO> update(@PathVariable UUID id, @RequestBody DisciplinaDTO disciplinaDTO) {
        return disciplinaService.update(id, disciplinaDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de Disciplina.", description = "Endpoint para remover uma Disciplina.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (disciplinaService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }

}
