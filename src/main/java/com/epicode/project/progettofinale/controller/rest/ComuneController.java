package com.epicode.project.progettofinale.controller.rest;

import com.epicode.project.progettofinale.model.Comune;
import com.epicode.project.progettofinale.model.dto.response.ComuneDTORes;
import com.epicode.project.progettofinale.services.ComuneService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/api/comune/")
@SecurityRequirement(name="bearerAuth")
public class ComuneController {

    @Autowired
    private ComuneService comuneSrv;

    @GetMapping("getAll")
   public ResponseEntity<Page<ComuneDTORes>> getAll() {
        return ResponseEntity.ok(comuneSrv.getAll());
    }

    @GetMapping("{name}")
    public ResponseEntity <ComuneDTORes> getByName(String name) {
return ResponseEntity.ok(comuneSrv.findByName(name));
    }
    @GetMapping("{id}")
    public ResponseEntity <ComuneDTORes> getById( Long id) {
        return ResponseEntity.ok(comuneSrv.findById(id));
    }

}
