package com.epicode.project.progettofinale.repository;

import com.epicode.project.progettofinale.model.EnumTipo;
import com.epicode.project.progettofinale.model.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long> {
    Boolean existsByTipo(EnumTipo tipo);

    Optional<Tipo> findByTipo(EnumTipo tipo);
}
