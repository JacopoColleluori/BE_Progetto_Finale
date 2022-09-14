package com.epicode.project.progettofinale.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProvinciaDTOReq {
    private String nome;
    private String sigla;
    private String regione;
}
