package com.epicode.project.progettofinale.model.dto.response;

import com.epicode.project.progettofinale.model.Cliente;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class IndirizzoDTORes {


    public String via;
    public int civico;
    private String localita;
    private int cap;

    private ComuneDTORes comune;

    private List<Cliente> clientiSedeLegale;

    private List<Cliente> clientiSedeOperativa;
}
