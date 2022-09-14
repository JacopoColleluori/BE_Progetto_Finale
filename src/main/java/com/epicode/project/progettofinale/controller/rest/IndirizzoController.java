package com.epicode.project.progettofinale.controller.rest;

import com.epicode.project.progettofinale.model.Indirizzo;
import com.epicode.project.progettofinale.services.IndirizzoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/indirizzo/")
@SecurityRequirement(name = "bearerAuth")
public class IndirizzoController {
    @Autowired
    private IndirizzoService indirizzoSrv;

    @GetMapping("getAll")
    public ResponseEntity<Page<Indirizzo>> getAll(Pageable pageable) {
        return null;
    }

    @GetMapping("{name}")
    public ResponseEntity<Indirizzo> getByName(Pageable pageable, String name) {
        return null;
    }

    @GetMapping("{id}")
    public ResponseEntity<Indirizzo> getById(Pageable pageable, Long id) {
        return null;
    }

}
