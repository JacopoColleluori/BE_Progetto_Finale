package com.epicode.project.progettofinale.services.impl;

import com.epicode.project.progettofinale.exception.EpicException;
import com.epicode.project.progettofinale.model.Cliente;
import com.epicode.project.progettofinale.model.Comune;
import com.epicode.project.progettofinale.model.dto.request.ClienteDTOReq;
import com.epicode.project.progettofinale.model.dto.response.ClienteDTORes;
import com.epicode.project.progettofinale.repository.*;
import com.epicode.project.progettofinale.services.ClienteService;
import com.epicode.project.progettofinale.services.ComuneService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Autowired
    private IndirizzoRepository indirizzoRepository;

    @Autowired
    private ComuneRepository comuneRepository;

    @Override
    public Page<ClienteDTORes> getAll(Pageable pageable) {
        List<Cliente> clienti = clienteRepository.findAll();
        List<ClienteDTORes> response = clienti.stream().map(cliente -> mapper.map(cliente, ClienteDTORes.class)).collect(Collectors.toList());
        Page<ClienteDTORes> page = new PageImpl<>(response);
        return page;
    }

    @Override
    public ClienteDTORes update(ClienteDTOReq clienteReq, Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new EpicException("Il cliente con id: " + id + "non esiste");
        }

        Optional<Comune> comuneLegale = comuneRepository.findByNomeComuneIgnoreCase(clienteReq.getSedeLegale().getNomeComune());

        if (comuneLegale.isEmpty()) {
            throw new EpicException("Il comune : " + comuneLegale.get().getNomeComune() + "non esiste'");
        }

        Optional<Comune> comuneOperativo = comuneRepository.findByNomeComuneIgnoreCase(clienteReq.getSedeOperativa().getNomeComune());
        Cliente cliente = mapper.map(clienteReq, Cliente.class);
        cliente.getSedeLegale().setComune(comuneLegale.get());
        cliente.getSedeOperativa().setComune(comuneOperativo.get());
        cliente.setId(id);
        return mapper.map(clienteRepository.save(cliente), ClienteDTORes.class);
    }

    @Override
    public void delete(ClienteDTORes cliente, Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new EpicException("Cliente con id: " + id + " non trovato");
        }
        clienteRepository.deleteById(id);
    }

    @Override
    public ClienteDTORes save(ClienteDTOReq clienteReq) {
        Cliente cliente = mapper.map(clienteReq, Cliente.class);
        if (!tipoRepository.existsByTipoIgnoreCase(cliente.getTipo().getTipo())) {
            throw new EpicException("Il tipo : " + cliente.getTipo().getTipo() + "non esiste");
        }
        Optional<Comune> comuneLegale = comuneRepository.findByNomeComuneIgnoreCase(clienteReq.getSedeLegale().getNomeComune());

        if (comuneLegale.isEmpty()) {
            throw new EpicException("Il comune : " + comuneLegale.get().getNomeComune() + "non esiste'");
        }
        Optional<Comune> comuneOperativo = comuneRepository.findByNomeComuneIgnoreCase(clienteReq.getSedeOperativa().getNomeComune());
        cliente.getSedeLegale().setComune(comuneLegale.get());
        cliente.getSedeOperativa().setComune(comuneOperativo.get());
        return mapper.map(clienteRepository.save(cliente), ClienteDTORes.class);
    }

    @Override
    public Page<ClienteDTORes> filterByFatturato(Long fatturatoX, Long fatturatoY) {
        List<Cliente> clienti = clienteRepository.findByFatturatoAnnualeBetweenOrderByFatturatoAnnuale(fatturatoX, fatturatoY);
        if (clienti.isEmpty()) {
            throw new EpicException("nessun cliente con fatturato tra: " + fatturatoX + " - " + fatturatoY + " trovato");
        }
        List<ClienteDTORes> response = clienti.stream().map(cliente -> mapper.map(cliente, ClienteDTORes.class)).collect(Collectors.toList());
        Page<ClienteDTORes> page = new PageImpl<>(response);
        return page;
    }

    @Override
    public Page<ClienteDTORes> filterByDataInserimento(LocalDate dataInserimento) {

        List<Cliente> clienti = clienteRepository.findByDataInserimentoOrderByDataInserimento(dataInserimento);
        if (clienti.isEmpty()) {
            throw new EpicException("nessun cliente per data: " + dataInserimento + " trovato");
        }
        List<ClienteDTORes> response = clienti.stream().map(cliente -> mapper.map(cliente, ClienteDTORes.class)).collect(Collectors.toList());
        Page<ClienteDTORes> page = new PageImpl<>(response);
        return page;
    }

    @Override
    public Page<ClienteDTORes> filterByDataUltimoContatto(LocalDate dataUltimoContatto) {
        List<Cliente> clienti = clienteRepository.findByDataUltimoContattoOrderByDataUltimoContatto(dataUltimoContatto);
        if (clienti.isEmpty()) {
            throw new EpicException("nessun cliente per la data: " + dataUltimoContatto + " trovata");
        }
        List<ClienteDTORes> response = clienti.stream().map(cliente -> mapper.map(cliente, ClienteDTORes.class)).collect(Collectors.toList());
        Page<ClienteDTORes> page = new PageImpl<>(response);
        return page;
    }

    @Override
    public Page<ClienteDTORes> filterByPartialName(String name) {
        List<Cliente> clienti = clienteRepository.findByOrderByRagioneSocialeContainingIgnoreCase(name);
        if (clienti.isEmpty()) {
            throw new EpicException("nessun cliente per nome: " + name + " trovato");
        }
        List<ClienteDTORes> response = clienti.stream().map(cliente -> mapper.map(cliente, ClienteDTORes.class)).collect(Collectors.toList());
        Page<ClienteDTORes> page = new PageImpl<>(response);
        return page;
    }

    @Override
    public ClienteDTORes filterByRagioneSociale(String ragioneSociale) {
        Optional<Cliente> cliente = clienteRepository.findByOrderByRagioneSocialeIgnoreCase(ragioneSociale);
        if (cliente.isEmpty()) {
            throw new EpicException("Il cliente con ragione sociale: " + ragioneSociale + " non esiste");
        }
        return mapper.map(cliente.get(), ClienteDTORes.class);
    }

    @Override
    public ClienteDTORes filterById(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new EpicException("Non esiste nessun cliente con l'id immesso");
        }
        Optional<Cliente> cliente = clienteRepository.findById(id);
        ClienteDTORes clienteDTO = mapper.map(cliente.get(), ClienteDTORes.class);
        return clienteDTO;
    }

    @Override
    public Page<ClienteDTORes> orderByName() {
        List<Cliente> clienti = clienteRepository.findAllByOrderByRagioneSocialeIgnoreCase();
        List<ClienteDTORes> response = clienti.stream().map(cliente -> mapper.map(cliente, ClienteDTORes.class)).collect(Collectors.toList());
        Page<ClienteDTORes> page = new PageImpl<>(response);
        return page;
    }

    @Override
    public Page<ClienteDTORes> orderByFatturato() {

        List<Cliente> clienti = clienteRepository.findAllByOrderByFatturatoAnnuale();
        List<ClienteDTORes> response = clienti.stream().map(cliente -> mapper.map(cliente, ClienteDTORes.class)).collect(Collectors.toList());
        Page<ClienteDTORes> page = new PageImpl<>(response);
        return page;
    }

    @Override
    public Page<ClienteDTORes> orderByDataInserimento() {

        List<Cliente> clienti = clienteRepository.findAllByOrderByDataInserimento();
        List<ClienteDTORes> response = clienti.stream().map(cliente -> mapper.map(cliente, ClienteDTORes.class)).collect(Collectors.toList());
        Page<ClienteDTORes> page = new PageImpl<>(response);
        return page;
    }

    @Override
    public Page<ClienteDTORes> orderByDataUltimoContatto() {
        List<Cliente> clienti = clienteRepository.findAllByOrderByDataUltimoContatto();
        List<ClienteDTORes> response = clienti.stream().map(cliente -> mapper.map(cliente, ClienteDTORes.class)).collect(Collectors.toList());
        Page<ClienteDTORes> page = new PageImpl<>(response);
        return page;
    }

    @Override
    public Page<ClienteDTORes> orderByProvinciaSedeLegale() {
        List<Cliente> clienti = clienteRepository.findAllByOrderBySedeLegale_Comune_NomeProvinciaIgnoreCase();
        List<ClienteDTORes> response = clienti.stream().map(cliente -> mapper.map(cliente, ClienteDTORes.class)).collect(Collectors.toList());
        Page<ClienteDTORes> page = new PageImpl<>(response);
        return page;
    }
}
