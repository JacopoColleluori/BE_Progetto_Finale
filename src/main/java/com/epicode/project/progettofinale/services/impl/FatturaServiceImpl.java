package com.epicode.project.progettofinale.services.impl;

import com.epicode.project.progettofinale.exception.EpicException;
import com.epicode.project.progettofinale.model.Cliente;
import com.epicode.project.progettofinale.model.Fattura;
import com.epicode.project.progettofinale.model.dto.request.FatturaDTOReq;
import com.epicode.project.progettofinale.model.dto.response.ClienteDTORes;
import com.epicode.project.progettofinale.model.dto.response.FatturaDTORes;
import com.epicode.project.progettofinale.repository.ClienteRepository;
import com.epicode.project.progettofinale.repository.FatturaRepository;
import com.epicode.project.progettofinale.repository.StatoRepository;
import com.epicode.project.progettofinale.services.FatturaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FatturaServiceImpl implements FatturaService {
    @Autowired
    private FatturaRepository fatturaRepository;
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private StatoRepository statoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Page<FatturaDTORes> getAll() {
        List<Fattura> fatture = fatturaRepository.findAll();
        List<FatturaDTORes> response = fatture.stream().map(fattura -> mapper.map(fatture, FatturaDTORes.class)).collect(Collectors.toList());
        Page<FatturaDTORes> page = new PageImpl<>(response);
        return page;
    }

    @Override
    public FatturaDTORes save(FatturaDTOReq fatturaReq) {

        if(!clienteRepository.existsByRagioneSocialeIgnoreCase(fatturaReq.getNomeCliente())){
            throw new EpicException("Il cliente con nome: "+ fatturaReq.getNomeCliente()+" non esiste");
        }

        Fattura fattura=mapper.map(fatturaReq,Fattura.class);

        if(!statoRepository.existsByNomeIgnoreCase(fattura.getStato().getNome())){
            throw new EpicException("Il tipo : "+fattura.getStato().getNome()+"non esiste");
        }


        fattura.setCliente(clienteRepository.findByOrderByRagioneSocialeIgnoreCase(fatturaReq.getNomeCliente()).get());
        fattura.setStato(statoRepository.findByNomeIgnoreCase(fatturaReq.getNomeStato()).get());
        return mapper.map(fatturaRepository.save(fattura), FatturaDTORes.class);
    }

    @Override
    public void delete(Long id) {

        if (!fatturaRepository.existsById(id)) {
            throw new EpicException("L'id della fattura immessa non esiste");
        }
        fatturaRepository.deleteById(id);

    }

    @Override
    public FatturaDTORes update(FatturaDTOReq fatturaReq, Long id) {
        if(!fatturaRepository.existsById(id)){
            throw new EpicException("Il cliente con id: "+id+ "non esiste");
        }

        if(!clienteRepository.existsByRagioneSocialeIgnoreCase(fatturaReq.getNomeCliente())){
            throw new EpicException("Il cliente con nome: "+ fatturaReq.getNomeCliente()+" non esiste");
        }

        Fattura fattura=mapper.map(fatturaReq,Fattura.class);

        if(!statoRepository.existsByNomeIgnoreCase(fattura.getStato().getNome())){
            throw new EpicException("Il tipo : "+fattura.getStato().getNome()+"non esiste");
        }

        fattura.setCliente(clienteRepository.findByOrderByRagioneSocialeIgnoreCase(fatturaReq.getNomeCliente()).get());
        fattura.setId(id);
        fattura.setStato(statoRepository.findByNomeIgnoreCase(fatturaReq.getNomeStato()).get());
        return mapper.map(fatturaRepository.save(fattura), FatturaDTORes.class);
    }

    @Override
    public Page<FatturaDTORes> filterByCliente(String nome) {
        List<Fattura> fatture = fatturaRepository.findByOrderByClienteRagioneSocialeIgnoreCase(nome);
       if(fatture.isEmpty()){
           throw new EpicException("Nessuna fattura trovato per il cliente: "+nome);
       }
        List<FatturaDTORes> response = fatture.stream().map(fattura -> mapper.map(fatture, FatturaDTORes.class)).collect(Collectors.toList());
        Page<FatturaDTORes> page = new PageImpl<>(response);
        return page;
    }

    @Override
    public Page<FatturaDTORes> filterByStato(String stato) {
        List<Fattura> fatture = fatturaRepository.findByOrderByStatoNomeIgnoreCase(stato);
        if(fatture.isEmpty()){
            throw new EpicException("Nessuna fattura trovato per lo stato: "+stato);
        }
        List<FatturaDTORes> response = fatture.stream().map(fattura -> mapper.map(fatture, FatturaDTORes.class)).collect(Collectors.toList());
        Page<FatturaDTORes> page = new PageImpl<>(response);
        return page;
    }

    @Override
    public Page<FatturaDTORes> filterByData(LocalDate date) {
        List<Fattura> fatture = fatturaRepository.findByOrderByData(date);
        if(fatture.isEmpty()){
            throw new EpicException("Nessuna fattura trovato per la data: "+date.toString());
        }
        List<FatturaDTORes> response = fatture.stream().map(fattura -> mapper.map(fatture, FatturaDTORes.class)).collect(Collectors.toList());
        Page<FatturaDTORes> page = new PageImpl<>(response);
        return page;
    }

    @Override
    public Page<FatturaDTORes> filterByAnno(Integer anno) {
        List<Fattura> fatture = fatturaRepository.findByOrderByAnno(anno);
        if(fatture.isEmpty()){
            throw new EpicException("Nessuna fattura trovato per l'anno: "+anno);
        }
        List<FatturaDTORes> response = fatture.stream().map(fattura -> mapper.map(fatture, FatturaDTORes.class)).collect(Collectors.toList());
        Page<FatturaDTORes> page = new PageImpl<>(response);
        return page;
    }

    @Override
    public Page<FatturaDTORes> filterByRangeImporti(BigDecimal importoX, BigDecimal importoY) {
        List<Fattura> fatture = fatturaRepository.findByOrderByImportoBetween(importoX, importoY);
        if(fatture.isEmpty()){
            throw new EpicException("Nessuna fattura trovato per il range: "+importoX+"-"+importoY);
        }
        List<FatturaDTORes> response = fatture.stream().map(fattura -> mapper.map(fatture, FatturaDTORes.class)).collect(Collectors.toList());
        Page<FatturaDTORes> page = new PageImpl<>(response);
        return page;
    }
}
