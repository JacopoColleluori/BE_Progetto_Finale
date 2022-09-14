package com.epicode.project.progettofinale.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProvinciaDTORes {

    private String nome;
    private String sigla;
    private String regione;

    private List<ComuneDTOResOnlyName> comuni;
}