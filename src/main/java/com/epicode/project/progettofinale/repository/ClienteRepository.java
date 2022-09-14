package com.epicode.project.progettofinale.repository;

import com.epicode.project.progettofinale.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    Boolean existsByRagioneSocialeIgnoreCase(String nome);

    //query per l'ordine
    List<Cliente> findAllByOrderByRagioneSocialeIgnoreCase();
    List<Cliente> findAllByOrderByFatturatoAnnuale();

    List<Cliente> findAllByOrderByDataInserimento();

    List<Cliente> findAllByOrderByDataUltimoContatto();

    List<Cliente> findAllByOrderBySedeLegale_Comune_NomeProvinciaIgnoreCase();

    //query per il filtraggio

    List<Cliente> findByOrderByRagioneSocialeContainingIgnoreCase(String nome); //il containing ignore case è l'equivalente JPA del % prima e dopo un input per prendere tutte le parole nel database che contengono la stringa immessa

    List<Cliente> findByFatturatoAnnualeBetweenOrderByFatturatoAnnuale(Long fatturatoX,Long fatturatoY);

    List<Cliente> findByDataInserimentoOrderByDataInserimento(LocalDate data);

    List<Cliente> findByDataUltimoContattoOrderByDataUltimoContatto(LocalDate data);

    Optional<Cliente> findByOrderByRagioneSocialeIgnoreCase(String nome);

}
