package com.epicode.project.progettofinale.controller.rest;

import com.epicode.project.progettofinale.model.Stato;
import com.epicode.project.progettofinale.model.dto.response.StatoDTORes;
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
    private StatoService statoSrv;
    @GetMapping("getAll")
    public ResponseEntity<Page<StatoDTORes>> getAll() {
        return ResponseEntity.ok(statoSrv.getAll());
    }

    @GetMapping("{name}")
    public ResponseEntity <StatoDTORes> getByName(String name) {
        return ResponseEntity.ok(statoSrv.findByName(name));
    }
    @GetMapping("{id}")
    public ResponseEntity <StatoDTORes> getById(Long id) {
        return ResponseEntity.ok(statoSrv.findById(id));
    }

}
