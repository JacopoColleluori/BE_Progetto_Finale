package com.epicode.project.progettofinale.model.dto.request;

import com.epicode.project.progettofinale.model.Stato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FatturaDTOReq {
    private Integer anno;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;
    private Integer numero;
    private BigDecimal importo;

    private String nomeStato;

    private String nomeCliente;
}
