package com.epicode.project.progettofinale.repository;

import com.epicode.project.progettofinale.model.Stato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatoRepository extends JpaRepository<Stato, Long> {
    Optional<Stato> findByNomeIgnoreCase(String nome);

    Boolean existsByNomeIgnoreCase(String nome);
}
