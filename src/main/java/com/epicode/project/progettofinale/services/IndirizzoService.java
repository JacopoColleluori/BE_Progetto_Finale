package com.epicode.project.progettofinale.services;

import com.epicode.project.progettofinale.model.dto.response.IndirizzoDTORes;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface IndirizzoService {
    Page<IndirizzoDTORes> getAll();


    void delete(Long id);

    IndirizzoDTORes getById(Long id);
}
