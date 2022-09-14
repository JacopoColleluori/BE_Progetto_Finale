package com.epicode.project.progettofinale.model.dto.request;

import com.epicode.project.progettofinale.model.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTOReq {
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


    private IndirizzoDTOReq sedeLegale;

    private IndirizzoDTOReq sedeOperativa;

    private Tipo tipo;
}
