package br.com.mirante.eduapi.controller;

import br.com.mirante.eduapi.dto.MaterialComplementarDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.MaterialComplementarMapper;
import br.com.mirante.eduapi.models.MaterialComplementar;
import br.com.mirante.eduapi.service.MaterialComplementarService;
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
@RequestMapping(value = "/Matcomplementar")
public class MaterialComplementarController {
    @Autowired
    private MaterialComplementarService materialComplementarService;

    @PreAuthorize("hasAuthority(@AUTHORITIES.MATERIALCOMPLMENTAR_CONSULTAR)")
    @GetMapping("/findAll")
    @Operation(summary = "Consultar Material Complementares.", description = "Endpoint para consultar Material Complementares.", security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<MaterialComplementarDTO>> findAll(SpecTemplate.MaterialComplementarSpec spec, Pageable page){
        Page<MaterialComplementar> consultaPage = materialComplementarService.findAll(spec, page);
        if(consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(MaterialComplementarMapper.INSTANCE::ToMaterialComplementarDTO), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(consultaPage.map(MaterialComplementarMapper.INSTANCE::ToMaterialComplementarDTO), HttpStatus.OK);
        }
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.MATERIALCOMPLMENTAR_CADASTRAR)")
    @PostMapping()
    @Operation(summary = "Cadastro de Material Complementar.", description = "Endpoint para cadastrar Material Complementar.", security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<MaterialComplementarDTO> create(@RequestBody MaterialComplementarDTO materialComplementarDTO) throws BusinessException {
        MaterialComplementarDTO savedMatComplementar = materialComplementarService.save(materialComplementarDTO);
        return ResponseEntity.ok(savedMatComplementar);
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.MATERIALCOMPLMENTAR_CONSULTAR)")
    @GetMapping("/{id}")
    @Operation(summary = "Buscar Material Complementar por ID.", description = "Endpoint para buscar a Material Complementar pelo id.", security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<MaterialComplementarDTO> getById(@PathVariable UUID id) {
        return materialComplementarService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.MATERIALCOMPLMENTAR_ATUALIZAR)")
    @PutMapping("/{id}")
    @Operation(summary = "Atualização de Material Complementar.", description = "Endpoint para atualizar os dados do Material Complementar.", security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<MaterialComplementarDTO> update(@PathVariable UUID id, @RequestBody MaterialComplementarDTO materialComplementarDTO) {
        return materialComplementarService.update(id, materialComplementarDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.MATERIALCOMPLMENTAR_DELETAR)")
    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de MaterialComplementar.", description = "Endpoint para remover uma MaterialComplementar.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (materialComplementarService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }

}
