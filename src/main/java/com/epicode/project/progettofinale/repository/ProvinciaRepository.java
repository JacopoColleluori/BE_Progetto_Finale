package com.epicode.project.progettofinale.repository;

import com.epicode.project.progettofinale.model.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {
    Optional<Provincia> findByNomeIgnoreCase(String name);

    Optional<Provincia> findBySiglaIgnoreCase(String sigla);

}
