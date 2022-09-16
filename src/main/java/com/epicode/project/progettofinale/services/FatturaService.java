package com.epicode.project.progettofinale.services;

import com.epicode.project.progettofinale.model.dto.request.FatturaDTOReq;
import com.epicode.project.progettofinale.model.dto.response.FatturaDTORes;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface FatturaService {

    //CRUD base
    Page<FatturaDTORes> getAll();

    FatturaDTORes save(FatturaDTOReq fattura);

    void delete(Long id);

    FatturaDTORes update(FatturaDTOReq fattura, Long id);

    //Filtraggio fatture
    Page<FatturaDTORes> filterByCliente(String nome);

    Page<FatturaDTORes> filterByStato(String stato);

    Page<FatturaDTORes> filterByData(LocalDate date);

    Page<FatturaDTORes> filterByAnno(Integer anno);

    Page<FatturaDTORes> filterByRangeImporti(BigDecimal importoX, BigDecimal importoY);


}
