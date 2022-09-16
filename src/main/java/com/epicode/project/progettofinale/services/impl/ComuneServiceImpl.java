package com.epicode.project.progettofinale.services.impl;

import com.epicode.project.progettofinale.exception.EpicException;
import com.epicode.project.progettofinale.model.Comune;
import com.epicode.project.progettofinale.model.dto.response.ComuneDTORes;
import com.epicode.project.progettofinale.repository.ComuneRepository;
import com.epicode.project.progettofinale.services.ComuneService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComuneServiceImpl implements ComuneService {

    @Autowired
    ComuneRepository comuneRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public Page<ComuneDTORes> getAll() {
        List<Comune> comuni = comuneRepository.findAll();

        List<ComuneDTORes> response = comuni.stream().map(cliente -> mapper.map(comuni, ComuneDTORes.class)).collect(Collectors.toList());
        Page<ComuneDTORes> page = new PageImpl<>(response);
        return page;
    }

    @Override
    public ComuneDTORes findByName(String name) {
        Optional<Comune> comune = comuneRepository.findByNomeComuneIgnoreCase(name);
        if (!comune.isPresent()) {
            throw new EpicException("Comune non esistente");
        }
        ComuneDTORes dto = mapper.map(comune, ComuneDTORes.class);
        return dto;
    }

    @Override
    public ComuneDTORes findById(Long id) {
        Optional<Comune> comune = comuneRepository.findById(id);
        if (!comune.isPresent()) {
            throw new EpicException("Id non trovato");
        }
        ComuneDTORes dto = mapper.map(comune.get(), ComuneDTORes.class);
        return dto;
    }
}
