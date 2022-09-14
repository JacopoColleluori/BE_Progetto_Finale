package com.epicode.project.progettofinale.services.impl;

import com.epicode.project.progettofinale.exception.EpicException;
import com.epicode.project.progettofinale.model.Indirizzo;
import com.epicode.project.progettofinale.model.Provincia;
import com.epicode.project.progettofinale.model.dto.response.IndirizzoDTORes;
import com.epicode.project.progettofinale.model.dto.response.ProvinciaDTORes;
import com.epicode.project.progettofinale.repository.ProvinciaRepository;
import com.epicode.project.progettofinale.services.ProvinciaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProvinciaServiceImpl implements ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;
    @Autowired
    ModelMapper mapper;

    @Override
    public Page<ProvinciaDTORes> getAll() {
        List<Provincia> province = provinciaRepository.findAll();
        List<ProvinciaDTORes> response = province.stream().map(provincia -> mapper.map(province, ProvinciaDTORes.class)).collect(Collectors.toList());
        Page<ProvinciaDTORes> page = new PageImpl<>(response);
        return page;
    }

    @Override
    public ProvinciaDTORes findByName(String name) {
        Optional<Provincia>provincia=provinciaRepository.findByNomeIgnoreCase(name);
        if (provincia.isEmpty()) {
            throw new EpicException("Il nome: "+name+ " immesso è di nessuna provincia presente nel database");
        }
        ProvinciaDTORes dto = mapper.map(provincia.get(), ProvinciaDTORes.class);
        return dto;
    }

    @Override
    public ProvinciaDTORes findById(Long id) {
        if (!provinciaRepository.existsById(id)) {
            throw new EpicException("L'id: "+id+ " immesso non esiste nel database");
        }
        Optional<Provincia> provincia = provinciaRepository.findById(id);
        ProvinciaDTORes dto = mapper.map(provincia.get(), ProvinciaDTORes.class);

        return dto;
    }

    @Override
    public ProvinciaDTORes findBySigla(String sigla) {
        Optional<Provincia> provincia = provinciaRepository.findBySiglaIgnoreCase(sigla);
        if (provincia.isEmpty()) {
            throw new EpicException("La sigla "+sigla+" non esiste nel database");
        }
        ProvinciaDTORes dto = mapper.map(provincia, ProvinciaDTORes.class);
        return dto;

    }
}
