package com.epicode.project.progettofinale.services.impl;

import com.epicode.project.progettofinale.exception.EpicException;
import com.epicode.project.progettofinale.model.Stato;
import com.epicode.project.progettofinale.model.dto.request.StatoDTOReq;
import com.epicode.project.progettofinale.model.dto.response.StatoDTORes;
import com.epicode.project.progettofinale.repository.StatoRepository;
import com.epicode.project.progettofinale.services.StatoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StatoServiceImpl implements StatoService {

    @Autowired
    StatoRepository statoRepository;
    @Autowired
    ModelMapper mapper;

    @Override
    public Page<StatoDTORes> getAll() {
        List<Stato> stati = statoRepository.findAll();
        if (stati.isEmpty()) {
            throw new EpicException("nessuno stato cliente trovato");
        }
        List<StatoDTORes> response = stati.stream().map(stato -> mapper.map(stato, StatoDTORes.class)).collect(Collectors.toList());
        Page<StatoDTORes> page = new PageImpl<>(response);
        return page;
    }

    @Override
    public StatoDTORes findByName(String name) {
        Optional<Stato> stato = statoRepository.findByNomeIgnoreCase(name);
        if (stato.isEmpty()) {
            throw new EpicException("Stato dal nome: " + name + " non trovato");
        }
        StatoDTORes dto = mapper.map(stato, StatoDTORes.class);
        return dto;
    }

    @Override
    public StatoDTORes findById(Long id) {
        Optional<Stato> stato = statoRepository.findById(id);
        if (stato.isEmpty()) {
            throw new EpicException("Stato con id: " + id + " non trovato");
        }
        StatoDTORes dto = mapper.map(stato, StatoDTORes.class);
        return dto;
    }

    @Override
    public StatoDTORes create(StatoDTOReq statoReq) {
        return mapper.map(statoRepository.save(mapper.map(statoReq, Stato.class)), StatoDTORes.class);
    }

    @Override
    public void delete(Long id) {
        if (!statoRepository.existsById(id)) {
            throw new EpicException("Stato fattura non trovato");
        }
        statoRepository.deleteById(id);
    }


}
