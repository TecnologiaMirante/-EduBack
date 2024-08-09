package br.com.mirante.eduapi.controller;

import br.com.mirante.eduapi.dto.AlunoDTO;
import br.com.mirante.eduapi.dto.AlunoDTOPost;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.AlunoMapper;
import br.com.mirante.eduapi.models.Aluno;
import br.com.mirante.eduapi.service.AlunoService;
import br.com.mirante.eduapi.specifications.SpecTemplate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
@Tag(description = "Retorna Dados dos Alunos", name = "Alunos")
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @PreAuthorize("hasAuthority(@AUTHORITIES.ALUNO_CONSULTAR)")
    @GetMapping("/findAll")
    @Operation(summary = "Consultar Alunos.", description = "Endpoint para consultar alunos.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Page<AlunoDTO>> findAll(SpecTemplate.AlunoSpec spec, Pageable page) {
        Page<Aluno> consultaPage = alunoService.findAll(spec, page);

        if (consultaPage.isEmpty()) {
            return new ResponseEntity<>(consultaPage.map(AlunoMapper.INSTANCE::alunoToAlunoDTO), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(consultaPage.map(AlunoMapper.INSTANCE::alunoToAlunoDTO), HttpStatus.OK);
        }
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.ALUNO_CADASTRAR)")
    @PostMapping("/")
    @Operation(summary = "Cadastrar Aluno.", description = "Endpoint para cadastrar Alunos.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<AlunoDTOPost> create(@Valid @RequestBody AlunoDTOPost alunoDTO) throws BusinessException {
        AlunoDTOPost aluno = alunoService.save(alunoDTO);

        return ResponseEntity.ok(aluno);
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.ALUNO_CONSULTAR)")
    @GetMapping("/{id}")
    @Operation(summary = "Buscar os Alunos pelo ID.", description = "Endpoint para buscar Alunos pelo ID.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<AlunoDTO> getById(@PathVariable UUID id)  {
        return alunoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.ALUNO_ATUALIZAR)")
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar o aluno pelo ID.", description = "Endpoint para atualizar Alunos.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<AlunoDTO> update (@PathVariable UUID id, @RequestBody AlunoDTO alunoDTO){
        return alunoService.update(id, alunoDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasAuthority(@AUTHORITIES.ALUNO_DELETAR)")
    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção de Aluno.", description = "Endpoint para remover um aluno.",
            security = {@SecurityRequirement(name = "bearer-key")})
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (alunoService.deleteById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}
