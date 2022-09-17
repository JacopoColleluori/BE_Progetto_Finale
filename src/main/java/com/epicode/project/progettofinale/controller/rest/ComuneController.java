package com.epicode.project.progettofinale.controller.rest;

import com.epicode.project.progettofinale.model.dto.response.ComuneDTORes;
import com.epicode.project.progettofinale.services.ComuneService;
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
@RequestMapping(value ="/api/comune/")
@SecurityRequirement(name="bearerAuth")
@Tag(name="Comune")
public class ComuneController {

    @Autowired
    private ComuneService comuneSrv;

    @GetMapping("getAll")
    @Operation(summary = "Lista di tutti i comuni")
   public ResponseEntity<Page<ComuneDTORes>> getAll() {
        return ResponseEntity.ok(comuneSrv.getAll());
    }

    @GetMapping("cercaPerNome/{nome}")
    @Operation(summary = "Ricerca comune per nome")
    public ResponseEntity <ComuneDTORes> getByName(String nome) {
return ResponseEntity.ok(comuneSrv.findByName(nome));
    }
    @GetMapping("cercaPerId/{id}")
    @Operation(summary = "Ricerca comune per Id")
    public ResponseEntity <ComuneDTORes> getById( Long id) {
        return ResponseEntity.ok(comuneSrv.findById(id));
    }

}
