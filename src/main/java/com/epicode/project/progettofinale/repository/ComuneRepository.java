package com.epicode.project.progettofinale.repository;

import com.epicode.project.progettofinale.model.Comune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComuneRepository extends JpaRepository<Comune,Long> {
    Optional<Comune> findByNomeComuneIgnoreCase(String nome);
}
