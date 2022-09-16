package com.epicode.project.progettofinale.services.impl;

import com.epicode.project.progettofinale.exception.EpicException;
import com.epicode.project.progettofinale.model.Indirizzo;
import com.epicode.project.progettofinale.model.dto.response.IndirizzoDTORes;
import com.epicode.project.progettofinale.repository.IndirizzoRepository;
import com.epicode.project.progettofinale.services.IndirizzoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IndirizzoServiceImpl implements IndirizzoService {

    @Autowired
    private IndirizzoRepository indirizzoRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public Page<IndirizzoDTORes> getAll() {
        List<Indirizzo> indirizzi = indirizzoRepository.findAll();
        List<IndirizzoDTORes> response = indirizzi.stream().map(indirizzo -> mapper.map(indirizzi, IndirizzoDTORes.class)).collect(Collectors.toList());
        Page<IndirizzoDTORes> page = new PageImpl<>(response);
        return page;
    }

    @Override
    public void delete(Long id) {
        if (!indirizzoRepository.existsById(id)) {
            throw new EpicException("L'id dell' indirizzo immesso non esiste");
        }
        indirizzoRepository.deleteById(id);
    }

    @Override
    public IndirizzoDTORes getById(Long id) {
        if (!indirizzoRepository.existsById(id)) {
            throw new EpicException("Non esiste nessun cliente con l'id immesso");
        }
        Optional<Indirizzo> indirizzo = indirizzoRepository.findById(id);
        IndirizzoDTORes indirizzoDTO = mapper.map(indirizzo.get(), IndirizzoDTORes.class);
        return indirizzoDTO;
    }
}
