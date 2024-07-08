package br.com.mirante.eduapi.controller;

import br.com.mirante.eduapi.dto.AlunoInteracaoDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.AlunoInteracaoMapper;
import br.com.mirante.eduapi.models.AlunoInteracao;
import br.com.mirante.eduapi.service.AlunoInteracaoService;
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
@Tag(description = "Retorna Dados dos alunos e suas interaçoes", name = "Aluno e interação")
@RequestMapping("/alunoInteracao")
public class AlunoInteracaoController {

    @Autowired
    private AlunoInteracaoService alunoInteracaoService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar as interações.", description = "Endpoint para consultar as interações.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<AlunoInteracaoDTO>> findAll(SpecTemplate.AlunoInterecaoSpec spec, Pageable page){
        Page<AlunoInteracao> consultaPage = alunoInteracaoService.findAll(spec, page);

        if(consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(AlunoInteracaoMapper.INSTANCE::alunoInteracaoToAlunoInteracaoDTO), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(consultaPage.map(AlunoInteracaoMapper.INSTANCE::alunoInteracaoToAlunoInteracaoDTO), HttpStatus.OK);
        }
    }

    @PostMapping("/")
    @Operation(summary = "Cadastro de interação.", description = "Endpoint para cadastrar uma interação.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<AlunoInteracaoDTO> create(@RequestBody AlunoInteracaoDTO alunoInteracaoDTO) throws BusinessException {
        AlunoInteracaoDTO savedInteracao = alunoInteracaoService.save(alunoInteracaoDTO);
        return ResponseEntity.ok(savedInteracao);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Interação por ID.", description = "Endpoint para buscar a interação pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<AlunoInteracaoDTO> getById(@PathVariable UUID id) {
        return alunoInteracaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualização da interação.", description = "Endpoint para atualizar os dados das interações.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<AlunoInteracaoDTO> update(@PathVariable UUID id, @RequestBody AlunoInteracaoDTO alunoInteracaoDTO) {
        return alunoInteracaoService.update(id, alunoInteracaoDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de interação.", description = "Endpoint para remover uma interação.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (alunoInteracaoService.deleteById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }

}
