package com.epicode.project.progettofinale.repository;

import com.epicode.project.progettofinale.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Boolean existsByRagioneSocialeIgnoreCase(String nome);

    //query per l'ordine
    List<Cliente> findAllByOrderByRagioneSociale();

    List<Cliente> findAllByOrderByFatturatoAnnuale();

    List<Cliente> findAllByOrderByDataInserimento();

    List<Cliente> findAllByOrderByDataUltimoContatto();

    List<Cliente> findAllByOrderBySedeLegale_Comune_NomeProvincia();

    //query per il filtraggio

    List<Cliente> findByRagioneSocialeContainingIgnoreCaseOrderByRagioneSociale(String nome); //il containing ignore case è l'equivalente JPA del % prima e dopo un input per prendere tutte le parole nel database che contengono la stringa immessa

    List<Cliente> findByFatturatoAnnualeBetweenOrderByFatturatoAnnuale(Long fatturatoX, Long fatturatoY);

    List<Cliente> findByDataInserimentoOrderByDataInserimento(LocalDate data);

    List<Cliente> findByDataUltimoContattoOrderByDataUltimoContatto(LocalDate data);

    Optional<Cliente> findByRagioneSocialeIgnoreCase(String nome);

}
