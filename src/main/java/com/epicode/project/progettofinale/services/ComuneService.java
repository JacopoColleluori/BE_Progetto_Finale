package com.epicode.project.progettofinale.services;

import com.epicode.project.progettofinale.model.Comune;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ComuneService {
    Page<Comune> getAll(Pageable pageable);
    Optional<Comune> findByName(String name);
    Optional<Comune> findById(Long id);
}
