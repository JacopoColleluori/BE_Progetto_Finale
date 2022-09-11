package com.epicode.project.progettofinale.services;

import com.epicode.project.progettofinale.model.Provincia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProvinciaService {
    Page<Provincia> getAll(Pageable pageable);
    Optional<Provincia> findByName(String name);
    Optional<Provincia> findById(Long id);
}
