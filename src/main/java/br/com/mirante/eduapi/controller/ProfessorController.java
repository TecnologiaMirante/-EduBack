package br.com.mirante.eduapi.controller;


import br.com.mirante.eduapi.dto.ProfessorDTO;
import br.com.mirante.eduapi.dto.ProfessorDTOPost;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.ProfessorMapper;
import br.com.mirante.eduapi.models.Professor;
import br.com.mirante.eduapi.service.ProfessorService;
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
@Tag(description = "Retorna Dados dos Professores", name = "Professor")
@RequestMapping(value = "/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar todos os professores", description = "Endpoint para consultar professores. ",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<ProfessorDTO>> findAll(SpecTemplate.ProfessorSpec spec, Pageable pageable) {
        Page<Professor> consultaPage = professorService.findAll(spec, pageable);

        if (consultaPage.isEmpty()){
            return  new ResponseEntity<>(consultaPage.map(ProfessorMapper.INSTANCE::professorToProfessorDTO), HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(consultaPage.map(ProfessorMapper.INSTANCE::professorToProfessorDTO), HttpStatus.OK);
        }
    }

    @PostMapping("/")
    @Operation(summary = "Cadastro de Professores.", description = "Endpoint para cadastrar professor.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<ProfessorDTOPost> create(@RequestBody ProfessorDTOPost professorDTO) throws BusinessException {

        ProfessorDTOPost professorSaved = professorService.save(professorDTO);

        return ResponseEntity.ok(professorSaved);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Professor por ID.", description = "Endpoint para buscar o professor pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<ProfessorDTO> getById(@PathVariable("id") UUID id) throws BusinessException {
        return professorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar os Professores por ID.", description = "Endpoint para atualizar os professores pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<ProfessorDTO> update(@RequestBody ProfessorDTO professorDTO, @PathVariable UUID id){
        return professorService.update(id,professorDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover Professor por ID.", description = "Endpoint para remover, o professor pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<ProfessorDTO> delete(@PathVariable UUID id){
        if (professorService.delete(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
