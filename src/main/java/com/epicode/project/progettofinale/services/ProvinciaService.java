package com.epicode.project.progettofinale.services;

import com.epicode.project.progettofinale.model.dto.response.ProvinciaDTORes;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface ProvinciaService {
    Page<ProvinciaDTORes> getAll();
    ProvinciaDTORes findByName(String name);
    ProvinciaDTORes findById(Long id);

    ProvinciaDTORes findBySigla(String sigla);
}
