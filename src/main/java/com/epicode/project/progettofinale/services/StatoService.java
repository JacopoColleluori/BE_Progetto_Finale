package com.epicode.project.progettofinale.services;

import com.epicode.project.progettofinale.model.dto.request.StatoDTOReq;
import com.epicode.project.progettofinale.model.dto.response.StatoDTORes;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface StatoService {
    Page<StatoDTORes> getAll();

    StatoDTORes findByName(String name);

    StatoDTORes findById(Long id);

    StatoDTORes create(StatoDTOReq stato);

    void delete(Long id);

}
