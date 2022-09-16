package com.epicode.project.progettofinale.repository;

import com.epicode.project.progettofinale.model.Indirizzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndirizzoRepository extends JpaRepository<Indirizzo, Long> {

}
