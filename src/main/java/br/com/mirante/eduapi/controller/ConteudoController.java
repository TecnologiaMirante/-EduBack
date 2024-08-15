package br.com.mirante.eduapi.controller;


import br.com.mirante.eduapi.dto.ConteudoDTO;
import br.com.mirante.eduapi.dto.ConteudoDTOpost;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.ConteudoMapper;
import br.com.mirante.eduapi.models.Conteudo;
import br.com.mirante.eduapi.service.ConteudoService;
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
@RequestMapping(value = "/Conteudo")
public class ConteudoController {
    @Autowired
    private ConteudoService conteudoService;

    @GetMapping("/findAll")
    @Operation(summary = "Consultar Conteudos.", description = "Endpoint para consultar Conteudos.", security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<ConteudoDTO>> findAll(SpecTemplate.ConteudoSpec spec, Pageable page){
        Page<Conteudo> consultaPage = conteudoService.findAll(spec, page);
        if(consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(ConteudoMapper.INSTANCE::ToConteudoDTO), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(consultaPage.map(ConteudoMapper.INSTANCE::ToConteudoDTO), HttpStatus.OK);
        }
    }

    @PostMapping()
    @Operation(summary = "Cadastro de Conteudo.", description = "Endpoint para cadastrar Conteudo.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<ConteudoDTOpost> create(@RequestBody ConteudoDTOpost conteudoDTOpost) throws BusinessException {
        ConteudoDTOpost savedConteudo = conteudoService.save(conteudoDTOpost);
        return ResponseEntity.ok(savedConteudo);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Conteudo por ID.", description = "Endpoint para buscar a Conteudo pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<ConteudoDTO> getById(@PathVariable UUID id) {
        return conteudoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualização de Conteudo.", description = "Endpoint para atualizar os dados das Conteudos.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<ConteudoDTOpost> update(@PathVariable UUID id, @RequestBody ConteudoDTOpost conteudoDTOpost) {
        return conteudoService.update(id, conteudoDTOpost)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de Conteudo.", description = "Endpoint para remover uma Conteudo.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (conteudoService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }

}
