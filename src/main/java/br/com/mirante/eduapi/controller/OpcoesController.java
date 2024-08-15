package br.com.mirante.eduapi.controller;

import br.com.mirante.eduapi.dto.OpcoesDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.OpcoesMapper;
import br.com.mirante.eduapi.models.Opcoes;
import br.com.mirante.eduapi.service.OpcoesService;
import br.com.mirante.eduapi.specifications.SpecTemplate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
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
@Tag(description = "Retorna Dados das Opções", name = "Opção")
@RequestMapping("/opcao")
public class OpcoesController {

    private OpcoesService opcoesService;

    @PreAuthorize("hasAuthority(@AUTHORITIES.OPCOES_CONSULTAR)")
    @GetMapping("/findAll")
    @Operation(summary = "Consultar Questão.", description = "Endpoint para consultar as Questões.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<OpcoesDTO>> findAll(SpecTemplate.OpcoesSpec spec, Pageable page) {
        Page<Opcoes> consultaPage = opcoesService.findAll(spec, page);
        if (consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(OpcoesMapper.INSTANCE::opcoestoOpcoesDTO),
                    HttpStatus.NOT_FOUND);
        }else{
            return  new ResponseEntity<>(consultaPage.map(OpcoesMapper.INSTANCE::opcoestoOpcoesDTO),HttpStatus.OK);
        }
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.OPCOES_CONSULTAR)")
    @GetMapping("/{id}")
    @Operation(summary = "Buscar Questão por ID.", description = "Endpoint para buscar as Questões pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<OpcoesDTO> getById(@PathVariable UUID id) {
        return opcoesService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.OPCOES_CADASTRAR)")
    @PostMapping()
    @Operation(summary = "Cadastro da Questão.", description = "Endpoint para cadastrar as Questões.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<OpcoesDTO> create(@RequestBody OpcoesDTO opcoesDTO) throws BusinessException {
        OpcoesDTO savedOpcoes =opcoesService.save(opcoesDTO);
        return ResponseEntity.ok(savedOpcoes);
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.OPCOES_ATUALIZAR)")
    @PutMapping("/{id}")
    @Operation(summary = "Atualização das Questões.", description = "Endpoint para atualizar os dados das Questões.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<OpcoesDTO> update(@PathVariable UUID id ,@RequestBody OpcoesDTO opcoesDTO){
        return  opcoesService.update(id, opcoesDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.OPCOES_DELETAR)")
    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção da questão.", description = "Endpoint para remover uma Questão.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        if (opcoesService.deleteById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();

    }

}
