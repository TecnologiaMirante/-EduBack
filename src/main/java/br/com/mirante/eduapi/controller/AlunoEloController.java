package br.com.mirante.eduapi.controller;


import br.com.mirante.eduapi.dto.AlunosEloDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.AlunosElosMapper;
import br.com.mirante.eduapi.models.AlunosElo;
import br.com.mirante.eduapi.service.AlunoEloService;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(description = "Retorna Dados dos elos dos alunos", name = "Aluno e seu elo")
@RequestMapping("/alunoElo")
public class AlunoEloController {
    @Autowired
    private AlunoEloService alunoEloService;

    @PreAuthorize("hasAuthority(@AUTHORITIES.ALUNOELO_CONSULTAR)")
    @GetMapping("/findAll")
    @Operation(summary = "Consultar os Elos dos  alunos.", description = "Endpoint para consultar os elos dos alunos.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<AlunosEloDTO>> findAll(SpecTemplate.AlunoEloSpec spec, Pageable page) {
        Page<AlunosElo> consultaPage = alunoEloService.findAll(spec, page);
        if (consultaPage.isEmpty()){
            return new ResponseEntity<>(consultaPage.map(AlunosElosMapper.INSTANCE::alunosEloToAlunosEloDTO) , HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(consultaPage.map(AlunosElosMapper.INSTANCE::alunosEloToAlunosEloDTO) , HttpStatus.OK);
        }
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.ALUNOELO_CADASTRAR)")
    @PostMapping("/")
    @Operation(summary = "Cadastro de elos para os alunos.", description = "Endpoint para cadastrar um elo para aluno.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<AlunosEloDTO> create(@RequestBody AlunosEloDTO alunoEloDTO) throws BusinessException {
        AlunosEloDTO alunoSaved = alunoEloService.save(alunoEloDTO);

        return ResponseEntity.ok(alunoSaved);
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.ALUNOELO_CONSULTAR)")
    @GetMapping("/{id}")
    @Operation(summary = "Buscar o elo do aluno por ID.", description = "Endpoint para buscar o elo do aluno pelo id.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<AlunosEloDTO> getById(@PathVariable UUID id){
        return alunoEloService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.ALUNOELO_ATUALIZAR)")
    @PutMapping("/{id}")
    @Operation(summary = "Atualização do elo do aluno.", description = "Endpoint para atualizar os dados do elo dos alunos.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<AlunosEloDTO> update(@RequestBody AlunosEloDTO alunoEloDTO, @PathVariable UUID id){
        return alunoEloService.update(id, alunoEloDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.ALUNOELO_DELETAR)")
    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de elo do aluno.", description = "Endpoint para remover um elo de aluno.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (alunoEloService.deleteById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}
