package com.epicode.project.progettofinale.repository;

import com.epicode.project.progettofinale.model.Fattura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface FatturaRepository extends JpaRepository<Fattura,Long> {
    List<Fattura> findByOrderByClienteRagioneSocialeIgnoreCase(String nome);
    List<Fattura> findByOrderByStatoNomeIgnoreCase(String nome);
    List<Fattura> findByOrderByData(LocalDate date);

    List<Fattura> findByOrderByAnno(Integer anno);

    List<Fattura> findByOrderByImportoBetween(BigDecimal importoX, BigDecimal importoY);


}
