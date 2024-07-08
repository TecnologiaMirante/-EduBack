package br.com.mirante.eduapi.controller;

import br.com.mirante.eduapi.dto.QuestoesDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.QuestoesMapper;
import br.com.mirante.eduapi.models.Questoes;
import br.com.mirante.eduapi.service.QuestoesService;
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
@Tag(description = "Retorna Dados das Questões", name = "Questoes")
@RequestMapping("/questoes")
public class QuestoesController {
    @Autowired
    private QuestoesService questoesService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar as Questões.", description = "Endpoint para consultar as Questões.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<QuestoesDTO>> findAll(SpecTemplate.QuestoesSpac spac, Pageable page){
        Page<Questoes> consultaPage = questoesService.findAll(spac,page);
        if (consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(QuestoesMapper.INSTANCE::questoesToQuestoesDTO), HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(consultaPage.map(QuestoesMapper.INSTANCE::questoesToQuestoesDTO),HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    @Operation(summary = "Buscar Questão por ID.", description = "Endpoint para buscar as Questões pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<QuestoesDTO> getById(@PathVariable UUID id){
        return questoesService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping()
    @Operation(summary = "Cadastro de Questões.", description = "Endpoint para cadastrar as Questões.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<QuestoesDTO> create(@RequestBody QuestoesDTO questoesDTO ) throws BusinessException {
        QuestoesDTO savedQuestao = questoesService.save(questoesDTO);
        return ResponseEntity.ok(savedQuestao);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Atualização das Questões.", description = "Endpoint para atualizar os dados das Questões.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<QuestoesDTO> update(@PathVariable UUID id , @RequestBody QuestoesDTO questoesDTO){
        return questoesService.update(id,questoesDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de Questão.", description = "Endpoint para remover uma Questão.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        if (questoesService.deleteById(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }
}
