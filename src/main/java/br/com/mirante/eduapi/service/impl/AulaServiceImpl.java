package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.models.Aula;
import br.com.mirante.eduapi.repository.AulaRepository;
import br.com.mirante.eduapi.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class AulaServiceImpl implements AulaService {
    @Autowired
    private AulaRepository aulaRepository;

  @Override
  public Page<Aula> findAll(Specification<Aula> spec , Pageable page){
      return aulaRepository.findAll(spec, page);
  }

}
