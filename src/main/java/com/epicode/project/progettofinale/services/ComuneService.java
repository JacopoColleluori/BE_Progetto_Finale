package com.epicode.project.progettofinale.services;

import com.epicode.project.progettofinale.model.dto.response.ComuneDTORes;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface ComuneService {
    Page<ComuneDTORes> getAll();

    ComuneDTORes findByName(String name);

    ComuneDTORes findById(Long id);
}
