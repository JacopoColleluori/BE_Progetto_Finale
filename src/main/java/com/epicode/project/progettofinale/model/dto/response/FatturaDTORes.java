package com.epicode.project.progettofinale.model.dto.response;

import com.epicode.project.progettofinale.model.Cliente;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FatturaDTORes {


    private Integer anno;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    private BigDecimal importo;

    private StatoDTORes stato;

    private String  clienteRagioneSociale;

}
