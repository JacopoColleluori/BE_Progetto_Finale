package com.epicode.project.progettofinale.controller.rest;

import com.epicode.project.progettofinale.model.Provincia;
import com.epicode.project.progettofinale.services.ProvinciaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/api/provincia/")
@SecurityRequirement(name="bearerAuth")
public class ProvinciaController {
    @Autowired
    private ProvinciaService provinciaSrv;

    @GetMapping("getAll")
    public ResponseEntity<Page<Provincia>> getAll(Pageable pageable) {
        return null;
    }

    @GetMapping("{name}")
    public ResponseEntity <Provincia> getByName(Pageable pageable,String name) {
        return null;
    }
    @GetMapping("{id}")
    public ResponseEntity <Provincia> getById(Pageable pageable,Long id) {
        return null;
    }

}
