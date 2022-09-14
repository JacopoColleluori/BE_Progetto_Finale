package com.epicode.project.progettofinale.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ComuneDTORes {


    private String nomeComune;


    private ProvinciaDTORes provincia;


}
