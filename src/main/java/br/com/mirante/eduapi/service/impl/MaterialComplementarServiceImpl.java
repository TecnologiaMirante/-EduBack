package br.com.mirante.eduapi.service.impl;

import br.com.mirante.eduapi.dto.MaterialComplementarDTO;
import br.com.mirante.eduapi.exceptions.BusinessException;
import br.com.mirante.eduapi.mappers.MaterialComplementarMapper;
import br.com.mirante.eduapi.models.MaterialComplementar;
import br.com.mirante.eduapi.repository.MaterialComplementarRepository;
import br.com.mirante.eduapi.service.MaterialComplementarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MaterialComplementarServiceImpl implements MaterialComplementarService {
    @Autowired
    private MaterialComplementarRepository materialComplementarRepository;

    @Override
    public Page<MaterialComplementar> findAll(Specification<MaterialComplementar> spec, Pageable page) {
        return materialComplementarRepository.findAll(spec, page);
    }

    @Override
    public MaterialComplementarDTO save(MaterialComplementarDTO materialComplementarDTO) throws BusinessException {

        MaterialComplementar materialComplementar = MaterialComplementarMapper.INSTANCE.ToMaterialComplementar(materialComplementarDTO);

        if (materialComplementarRepository.findById(materialComplementar.getId()).isPresent()){
            throw new BusinessException("MaterialComplementar já existe com esse codigo");
        }
        materialComplementar = materialComplementarRepository.save(materialComplementar);

        return MaterialComplementarMapper.INSTANCE.ToMaterialComplementarDTO(materialComplementar);
    }

    @Override
    public Optional<MaterialComplementarDTO> findById(UUID id) {
        return materialComplementarRepository.findById(id)
                .map(MaterialComplementarMapper.INSTANCE::ToMaterialComplementarDTO);
    }

    @Override
    public Optional<MaterialComplementarDTO> update(UUID id, MaterialComplementarDTO materialComplementarDTO) {
        if (materialComplementarRepository.existsById(id)) {
            MaterialComplementar materialComplementar = MaterialComplementarMapper.INSTANCE.ToMaterialComplementar(materialComplementarDTO);
            materialComplementar.setId(id);
            materialComplementar = materialComplementarRepository.save(materialComplementar);
            return Optional.of(MaterialComplementarMapper.INSTANCE.ToMaterialComplementarDTO(materialComplementar));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID id) {
        if (materialComplementarRepository.existsById(id)) {
            materialComplementarRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
