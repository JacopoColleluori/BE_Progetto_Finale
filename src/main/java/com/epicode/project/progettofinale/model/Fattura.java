package com.epicode.project.progettofinale.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor
public class Fattura {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer anno;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private BigDecimal importo;
    @ManyToOne
    private Stato stato;
    @ManyToOne
    private Cliente cliente;

}
