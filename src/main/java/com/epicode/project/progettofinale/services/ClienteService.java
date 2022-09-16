package com.epicode.project.progettofinale.services;

import com.epicode.project.progettofinale.model.dto.request.ClienteDTOReq;
import com.epicode.project.progettofinale.model.dto.response.ClienteDTORes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


public interface ClienteService {

    //CRUD base
    Page<ClienteDTORes> getAll();

    ClienteDTORes update(ClienteDTOReq cliente, Long id);

    void delete(Long id);

    ClienteDTORes save(ClienteDTOReq cliente);

    //metodi per il filtraggio
    Page<ClienteDTORes> filterByFatturato(Long fatturatoX, Long fatturatoY);

    Page<ClienteDTORes> filterByDataInserimento(LocalDate dataInserimento);

    Page<ClienteDTORes> filterByDataUltimoContatto(LocalDate dataUltimoContatto);

    Page<ClienteDTORes> filterByPartialName(String name);

    ClienteDTORes filterByRagioneSociale(String ragioneSociale);

    ClienteDTORes filterById(Long id);


    //metodi per l'ordine
    Page<ClienteDTORes> orderByName();

    Page<ClienteDTORes> orderByFatturato();

    Page<ClienteDTORes> orderByDataInserimento();

    Page<ClienteDTORes> orderByDataUltimoContatto();

    Page<ClienteDTORes> orderByProvinciaSedeLegale();

}
