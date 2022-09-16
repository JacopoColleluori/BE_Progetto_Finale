package com.epicode.project.progettofinale.model.dto.response;

import com.epicode.project.progettofinale.model.Tipo;
import com.epicode.project.progettofinale.model.dto.request.TipoDTOReq;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ClienteDTORes {
    private String ragioneSociale;


    private Long partitaIva;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataInserimento;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataUltimoContatto;
    private Long fatturatoAnnuale;
    private String pec;
    private Long telefono;
    private String emailContatto;
    private String nomeContatto;
    private String cognomeContatto;
    private Long telefonoContatto;


    private IndirizzoDTORes sedeLegale;

    private IndirizzoDTORes sedeOperativa;

    private TipoDTORes tipo;
}
