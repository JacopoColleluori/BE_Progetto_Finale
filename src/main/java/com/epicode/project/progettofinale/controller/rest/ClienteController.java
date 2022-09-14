package com.epicode.project.progettofinale.controller.rest;

import com.epicode.project.progettofinale.model.Cliente;
import com.epicode.project.progettofinale.services.ClienteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(value ="/api/cliente/")
@SecurityRequirement(name="bearerAuth")
public class ClienteController {

    @Autowired
    private ClienteService clienteSrv;

    @GetMapping("getAll")
    public ResponseEntity<Page<Cliente>> findAll(Pageable pageable){
        return null;
    }

    @GetMapping("filtroPerFatturato/{fatturatoX}/{fatturatoY}")
    public ResponseEntity<Page<Cliente>> filterByFatturato(Pageable pageable, @PathVariable Long fatturatoX, @PathVariable Long FatturatoY){
        return null;
    }
    @GetMapping("filtroPerDataInserimento/{data}")
    public ResponseEntity<Page<Cliente>> filterByDataInserimento(Pageable pageable, @PathVariable LocalDate data){
        return null;
    }

    @GetMapping("filtroPerDataUltimoContatto/{data}")
    public ResponseEntity<Page<Cliente>> filterByDataUltimoContatto(Pageable pageable, @PathVariable LocalDate data){
        return null;
    }
    @GetMapping("filtroPerNomeParziale/{nome}")
    public ResponseEntity<Page<Cliente>> filterByNome(Pageable pageable, @PathVariable String nome){
        return null;
    }

    @GetMapping("filtroPerId/{id}")
    public ResponseEntity<Page<Cliente>> filterById(Pageable pageable, @PathVariable Long id){
        return null;
    }

    @GetMapping("orderByName")
    public ResponseEntity<Page<Cliente>> orderByName(Pageable pageable){
        return null;
    }
    @GetMapping("orderByFatturato")
    public ResponseEntity<Page<Cliente>> orderByFatturato(Pageable pageable){
        return null;
    }
    @GetMapping("orderByDataInserimento")
    public ResponseEntity<Page<Cliente>> orderByDataInserimento(Pageable pageable){
        return null;
    }
    @GetMapping("orderByDataUltimoContatto")
    public ResponseEntity<Page<Cliente>> orderByDataUltimoContatto(Pageable pageable){
        return null;
    }
    @GetMapping("orderByProvinciaSedeLegale")
    public ResponseEntity<Page<Cliente>> orderByProvinciaSedeLegale(Pageable pageable){
        return null;
    }

    @PostMapping("aggiungi")
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        return null;
    }
    @PutMapping("{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente){
        return null;
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return null;
    }
}
