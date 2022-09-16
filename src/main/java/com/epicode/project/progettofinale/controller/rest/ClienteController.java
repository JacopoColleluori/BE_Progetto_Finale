package com.epicode.project.progettofinale.controller.rest;

import com.epicode.project.progettofinale.model.Cliente;
import com.epicode.project.progettofinale.model.dto.request.ClienteDTOReq;
import com.epicode.project.progettofinale.model.dto.response.ClienteDTORes;
import com.epicode.project.progettofinale.services.ClienteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Page<ClienteDTORes>> findAll(){
        return  ResponseEntity.ok(clienteSrv.getAll());
    }

    @GetMapping("filtroPerFatturato/{fatturatoX}/{fatturatoY}")
    public ResponseEntity<Page<ClienteDTORes>> filterByFatturato( @PathVariable Long fatturatoX, @PathVariable Long FatturatoY){
        return ResponseEntity.ok(clienteSrv.filterByFatturato(fatturatoX, FatturatoY));
    }
    @GetMapping("filtroPerDataInserimento/{data}")
    public ResponseEntity<Page<ClienteDTORes>> filterByDataInserimento( @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate data){
        return ResponseEntity.ok(clienteSrv.filterByDataInserimento(data));
    }

    @GetMapping("filtroPerDataUltimoContatto/{data}")
    public ResponseEntity<Page<ClienteDTORes>> filterByDataUltimoContatto( @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate data){
        return ResponseEntity.ok(clienteSrv.filterByDataUltimoContatto(data));
    }
    @GetMapping("filtroPerNomeParziale/{nome}")
    public ResponseEntity<Page<ClienteDTORes>> filterByNome( @PathVariable String nome){
        return ResponseEntity.ok(clienteSrv.filterByPartialName(nome));
    }

    @GetMapping("filtroPerId/{id}")
    public ResponseEntity<ClienteDTORes> filterById( @PathVariable Long id){
        return ResponseEntity.ok(clienteSrv.filterById(id));
    }

    @GetMapping("orderByName")
    public ResponseEntity<Page<ClienteDTORes>> orderByName(){
        return ResponseEntity.ok(clienteSrv.orderByName());
    }
    @GetMapping("orderByFatturato")
    public ResponseEntity<Page<ClienteDTORes>> orderByFatturato(){
        return ResponseEntity.ok(clienteSrv.orderByFatturato());
    }
    @GetMapping("orderByDataInserimento")
    public ResponseEntity<Page<ClienteDTORes>> orderByDataInserimento(){
        return ResponseEntity.ok(clienteSrv.orderByDataInserimento());
    }
    @GetMapping("orderByDataUltimoContatto")
    public ResponseEntity<Page<ClienteDTORes>> orderByDataUltimoContatto(){
        return ResponseEntity.ok(clienteSrv.orderByDataUltimoContatto());
    }
    @GetMapping("orderByProvinciaSedeLegale")
    public ResponseEntity<Page<ClienteDTORes>> orderByProvinciaSedeLegale(){
        return ResponseEntity.ok(clienteSrv.orderByProvinciaSedeLegale());
    }

    @PostMapping("aggiungi")
    public ResponseEntity<ClienteDTORes> create(@RequestBody ClienteDTOReq clienteReq){
        return new  ResponseEntity<ClienteDTORes>(clienteSrv.save(clienteReq),HttpStatus.CREATED);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<ClienteDTORes> update(@PathVariable Long id, @RequestBody ClienteDTOReq clienteReq){
        return ResponseEntity.ok(clienteSrv.update( clienteReq,id));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        clienteSrv.delete(id);
        return ResponseEntity.ok("eliminazione dell'utente con id: "+id+" effettuata");
    }
}
