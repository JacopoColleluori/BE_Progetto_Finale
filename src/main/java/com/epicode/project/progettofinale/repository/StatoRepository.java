package com.epicode.project.progettofinale.repository;

import com.epicode.project.progettofinale.model.Stato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatoRepository extends JpaRepository<Stato,Long> {
    Optional<Stato> findByNomeIgnoreCase(String nome);

    Boolean existsByNomeIgnoreCase(String nome);
}
