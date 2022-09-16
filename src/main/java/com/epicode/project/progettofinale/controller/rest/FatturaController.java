package com.epicode.project.progettofinale.controller.rest;

import com.epicode.project.progettofinale.model.dto.request.FatturaDTOReq;
import com.epicode.project.progettofinale.model.dto.response.FatturaDTORes;
import com.epicode.project.progettofinale.services.FatturaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping(value ="/api/fattura/")
@SecurityRequirement(name="bearerAuth")
public class FatturaController {
    @Autowired
    private FatturaService fatturaSrv;

    @GetMapping("getAll")
    ResponseEntity<Page<FatturaDTORes>> getAll(){
        return ResponseEntity.ok(fatturaSrv.getAll());
    }
    @GetMapping("filterByCliente/{nome}")
    ResponseEntity<Page<FatturaDTORes>> filterByCliente( @PathVariable String nome){
        return ResponseEntity.ok(fatturaSrv.filterByCliente(nome));
    }

    @GetMapping("filterByStato/{stato}")
    ResponseEntity<Page<FatturaDTORes>> filterByStato( @PathVariable String stato){
        return ResponseEntity.ok(fatturaSrv.filterByStato(stato));
    }

    @GetMapping("filterByData/{data}")
    ResponseEntity<Page<FatturaDTORes>> filterByData( @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate data ){
   return ResponseEntity.ok(fatturaSrv.filterByData(data));
    }
    @GetMapping("filterByAnno/{anno}")
    ResponseEntity<Page<FatturaDTORes>> filterByAnno( @PathVariable Integer anno ){
        return ResponseEntity.ok(fatturaSrv.filterByAnno(anno));
    }
    @GetMapping("filterByImporti/{importoX}/{importoY}")
    ResponseEntity<Page<FatturaDTORes>> filterByImporti( @PathVariable BigDecimal importoX,@PathVariable BigDecimal importoY ){
        return ResponseEntity.ok(fatturaSrv.filterByRangeImporti(importoX,importoY));
    }

    @PostMapping("create")
    ResponseEntity<FatturaDTORes> create(@RequestBody FatturaDTOReq fatturaReq){
        return new ResponseEntity<FatturaDTORes>(fatturaSrv.save(fatturaReq), HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    ResponseEntity<FatturaDTORes> update(@RequestBody FatturaDTOReq fatturaReq,@PathVariable Long id){
        return new ResponseEntity<FatturaDTORes>(fatturaSrv.update(fatturaReq,id), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    ResponseEntity<String> delete(@PathVariable Long id){
        fatturaSrv.delete(id);
        return new ResponseEntity<>("Fattura eliminata",HttpStatus.ACCEPTED);
    }
}
