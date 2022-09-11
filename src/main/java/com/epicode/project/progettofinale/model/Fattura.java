package com.epicode.project.progettofinale.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor
public class Fattura {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer anno;

    private Date date;

    private BigDecimal importo;
    @ManyToOne
    private Stato stato;
    @ManyToOne
    private Cliente cliente;

}
