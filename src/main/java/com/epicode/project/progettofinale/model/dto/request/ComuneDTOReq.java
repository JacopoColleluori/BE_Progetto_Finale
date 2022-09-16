package com.epicode.project.progettofinale.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComuneDTOReq {
    private String nomeComune;
    private ProvinciaDTOReq provincia;
}
