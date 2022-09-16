package com.epicode.project.progettofinale.repository;

import com.epicode.project.progettofinale.model.Fattura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface FatturaRepository extends JpaRepository<Fattura, Long> {
    List<Fattura> findByClienteRagioneSocialeIgnoreCaseOrderByClienteRagioneSociale(String nome);

    List<Fattura> findByStatoNomeIgnoreCaseOrderByStatoNome(String nome);

    List<Fattura> findByDataOrderByData(LocalDate date);

    List<Fattura> findByAnnoOrderByAnno(Integer anno);

    List<Fattura> findByImportoBetweenOrderByImporto(Double importoX, Double importoY);


}
