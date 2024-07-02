package br.com.mirante.eduapi.service;

import br.com.mirante.eduapi.models.Aula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface AulaService {
    Page<Aula> findAll(Specification<Aula> spec, Pageable page);
}
