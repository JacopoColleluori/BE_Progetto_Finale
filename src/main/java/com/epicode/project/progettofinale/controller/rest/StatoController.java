package com.epicode.project.progettofinale.controller.rest;

import com.epicode.project.progettofinale.model.Stato;
import com.epicode.project.progettofinale.services.StatoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/api/stato/")
@SecurityRequirement(name="bearerAuth")
public class StatoController {
    @Autowired
    StatoService statoSrv;
    @GetMapping("getAll")
    public ResponseEntity<Page<Stato>> getAll(Pageable pageable) {
        return null;
    }

    @GetMapping("{name}")
    public ResponseEntity <Stato> getByName(Pageable pageable,String name) {
        return null;
    }
    @GetMapping("{id}")
    public ResponseEntity <Stato> getById(Pageable pageable,Long id) {
        return null;
    }

}
