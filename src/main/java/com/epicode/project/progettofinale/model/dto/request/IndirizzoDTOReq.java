package com.epicode.project.progettofinale.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndirizzoDTOReq {
    public String via;
    public int civico;
    private String localita;
    private int cap;

    private String  nomeComune;
}
