package com.epicode.project.progettofinale.controller.rest;

import com.epicode.project.progettofinale.model.dto.response.IndirizzoDTORes;
import com.epicode.project.progettofinale.services.IndirizzoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/indirizzo/")
@SecurityRequirement(name = "bearerAuth")
@Tag(name="Indirizzo")
public class IndirizzoController {
    @Autowired
    private IndirizzoService indirizzoSrv;

    @GetMapping("getAll")
    @Operation(summary = "Lista di tutti gli indirizzi")
    public ResponseEntity<Page<IndirizzoDTORes>> getAll() {
        return ResponseEntity.ok(indirizzoSrv.getAll());
    }

    @GetMapping("filtroPerId/{id}")
    @Operation(summary = "Ricerca indirizzi per id")
    public ResponseEntity<IndirizzoDTORes> getById(Long id) {
        return ResponseEntity.ok(indirizzoSrv.getById(id));
    }
}
