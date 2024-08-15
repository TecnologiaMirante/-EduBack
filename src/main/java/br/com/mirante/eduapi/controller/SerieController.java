package br.com.mirante.eduapi.controller;

import br.com.mirante.eduapi.dto.SerieDTO;
import br.com.mirante.eduapi.dto.SerieDTOpost;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.SerieMapper;
import br.com.mirante.eduapi.models.Serie;
import br.com.mirante.eduapi.service.SerieService;
import br.com.mirante.eduapi.specifications.SpecTemplate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/Serie")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @PreAuthorize("hasAuthority(@AUTHORITIES.SERIE_CONSULTAR)")
    @GetMapping("/findAll")
    @Operation(summary = "Consultar todas as series", description = "Endpoint para consultar series. ",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<SerieDTO>> findAll(SpecTemplate.SerieSpec spec, Pageable pageable) {
        Page<Serie> consultaPage = serieService.findAll(spec, pageable);

        if (consultaPage.isEmpty()){
            return  new ResponseEntity<>(consultaPage.map(SerieMapper.INSTANCE::ToserieDTO), HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(consultaPage.map(SerieMapper.INSTANCE::ToserieDTO), HttpStatus.OK);
        }
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.SERIE_CADASTRAR)")
    @PostMapping("/")
    @Operation(summary = "Cadastro Serie.", description = "Endpoint para cadastrar serie. ",
    security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<SerieDTOpost> create(@RequestBody SerieDTOpost serieDTOpost) throws BusinessException{

        SerieDTOpost serieSaved = serieService.save(serieDTOpost);

        return ResponseEntity.ok(serieSaved);
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.SERIE_CONSULTAR)")
    @GetMapping("/{id}")
    @Operation(summary = "Buscar Serie por ID.", description = "Endpoint para buscar Serie pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<SerieDTO> getById(@PathVariable("id") UUID id) throws BusinessException {
        return serieService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.SERIE_ATUALIZAR)")
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar as Series por ID.", description = "Endpoint para atualizar as Series pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<SerieDTOpost> update(@RequestBody SerieDTOpost serieDTOpost, @PathVariable UUID id){
        return serieService.update(id,serieDTOpost)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.SERIE_DELETAR)")
    @DeleteMapping("/{id}")
    @Operation(summary = "Remover Serie por ID.", description = "Endpoint para remover serie pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<SerieDTO> delete(@PathVariable UUID id){
        if (serieService.delete(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}


