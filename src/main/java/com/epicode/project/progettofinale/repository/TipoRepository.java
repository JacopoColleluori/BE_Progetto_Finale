package com.epicode.project.progettofinale.repository;

import com.epicode.project.progettofinale.model.EnumTipo;
import com.epicode.project.progettofinale.model.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<Tipo,Long> {
    Boolean existsByTipoIgnoreCase(EnumTipo tipo);
}
