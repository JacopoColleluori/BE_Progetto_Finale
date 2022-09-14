package com.epicode.project.progettofinale.controller.rest;

import com.epicode.project.progettofinale.model.Fattura;
import com.epicode.project.progettofinale.services.FatturaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping(value ="/api/fattura/")
@SecurityRequirement(name="bearerAuth")
public class FatturaController {
    @Autowired
    private FatturaService fatturaSrv;

    @GetMapping("getAll")
    ResponseEntity<Page<Fattura>> getAll(){
        return null;
    }
    @GetMapping("filterByCliente/{nome}")
    ResponseEntity<Page<Fattura>> filterByCliente(Pageable pageable, @PathVariable String nome){
        return null;
    }

    @GetMapping("filterByStato/{stato}")
    ResponseEntity<Page<Fattura>> filterByStato(Pageable pageable, @PathVariable String stato){
        return null;
    }

    @GetMapping("filterByData/{data}")
    ResponseEntity<Page<Fattura>> filterByData(Pageable pageable, @PathVariable LocalDate data ){
   return null;
    }
    @GetMapping("filterByAnno/{anno}")
    ResponseEntity<Page<Fattura>> filterByAnno(Pageable pageable, @PathVariable Integer data ){
        return null;
    }
    @GetMapping("filterByImporti/{importoX}/{importoY}}")
    ResponseEntity<Page<Fattura>> filterByImporti(Pageable pageable, @PathVariable BigDecimal importoX,@PathVariable BigDecimal importoY ){
        return null;
    }

}
