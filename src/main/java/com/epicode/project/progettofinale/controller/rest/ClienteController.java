package com.epicode.project.progettofinale.controller.rest;

import com.epicode.project.progettofinale.model.dto.request.ClienteDTOReq;
import com.epicode.project.progettofinale.model.dto.response.ClienteDTORes;
import com.epicode.project.progettofinale.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(value ="/api/cliente/")
@SecurityRequirement(name="bearerAuth")
@Tag(name="Cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteSrv;

    @GetMapping("getAll")
    @Operation(summary = "Lista di tutti i clienti")
    public ResponseEntity<Page<ClienteDTORes>> findAll(){
        return  ResponseEntity.ok(clienteSrv.getAll());
    }

    @GetMapping("filtroPerFatturato/{fatturatoX}/{fatturatoY}")
    @Operation(summary = "ricerca dei clienti per un range di fatturato")
    public ResponseEntity<Page<ClienteDTORes>> filterByFatturato( @PathVariable Long fatturatoX, @PathVariable Long FatturatoY){
        return ResponseEntity.ok(clienteSrv.filterByFatturato(fatturatoX, FatturatoY));
    }
    @GetMapping("filtroPerDataInserimento/{data}")
    @Operation(summary = "ricerca dei clienti per Data di inserimento")
    public ResponseEntity<Page<ClienteDTORes>> filterByDataInserimento( @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate data){
        return ResponseEntity.ok(clienteSrv.filterByDataInserimento(data));
    }

    @GetMapping("filtroPerDataUltimoContatto/{data}")
    @Operation(summary = "ricerca dei clienti per Data Ultimo Contatto")
    public ResponseEntity<Page<ClienteDTORes>> filterByDataUltimoContatto( @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate data){
        return ResponseEntity.ok(clienteSrv.filterByDataUltimoContatto(data));
    }
    @GetMapping("filtroPerNomeParziale/{nome}")
    @Operation(summary = "ricerca dei clienti per Nome anche parziale")
    public ResponseEntity<Page<ClienteDTORes>> filterByNome( @PathVariable String nome){
        return ResponseEntity.ok(clienteSrv.filterByPartialName(nome));
    }

    @GetMapping("filtroPerId/{id}")
    @Operation(summary = "ricerca dei clienti per Id")
    public ResponseEntity<ClienteDTORes> filterById( @PathVariable Long id){
        return ResponseEntity.ok(clienteSrv.filterById(id));
    }

    @GetMapping("orderByName")
    @Operation(summary = "ordine dei clienti per Nome in modo alfabetico")
    public ResponseEntity<Page<ClienteDTORes>> orderByName(){
        return ResponseEntity.ok(clienteSrv.orderByName());
    }
    @GetMapping("orderByFatturato")
    @Operation(summary = "ordine dei clienti per Nome in modo ascendente")
    public ResponseEntity<Page<ClienteDTORes>> orderByFatturato(){
        return ResponseEntity.ok(clienteSrv.orderByFatturato());
    }
    @GetMapping("orderByDataInserimento")
    @Operation(summary = "ordine dei clienti per Data Inserimento")
    public ResponseEntity<Page<ClienteDTORes>> orderByDataInserimento(){
        return ResponseEntity.ok(clienteSrv.orderByDataInserimento());
    }
    @GetMapping("orderByDataUltimoContatto")
    @Operation(summary = "ordine dei clienti per Data dell'Ultimo Contatto")
    public ResponseEntity<Page<ClienteDTORes>> orderByDataUltimoContatto(){
        return ResponseEntity.ok(clienteSrv.orderByDataUltimoContatto());
    }
    @GetMapping("orderByProvinciaSedeLegale")
    @Operation(summary = "ordine dei clienti per la Provincia della Sede Legale")
    public ResponseEntity<Page<ClienteDTORes>> orderByProvinciaSedeLegale(){
        return ResponseEntity.ok(clienteSrv.orderByProvinciaSedeLegale());
    }

    @PostMapping("aggiungi")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Creazione del Cliente")
    public ResponseEntity<ClienteDTORes> create(@RequestBody ClienteDTOReq clienteReq){
        return new  ResponseEntity<ClienteDTORes>(clienteSrv.save(clienteReq),HttpStatus.CREATED);
    }
    @PutMapping("update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Aggiornamento del Cliente")
    public ResponseEntity<ClienteDTORes> update(@PathVariable Long id, @RequestBody ClienteDTOReq clienteReq){
        return ResponseEntity.ok(clienteSrv.update( clienteReq,id));
    }
    @DeleteMapping("delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Eliminazione del Cliente")
    public ResponseEntity<String> delete(@PathVariable Long id){
        clienteSrv.delete(id);
        return new ResponseEntity<String>("eliminazione dell'utente con id: "+id+" effettuata",HttpStatus.NOT_FOUND);
    }
}
