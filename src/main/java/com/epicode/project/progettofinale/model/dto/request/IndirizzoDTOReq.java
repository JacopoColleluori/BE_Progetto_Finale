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
    private String cap;

    private String nomeComune;
}
