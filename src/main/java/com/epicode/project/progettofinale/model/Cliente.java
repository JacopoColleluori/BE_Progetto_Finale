package com.epicode.project.progettofinale.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @OneToMany(mappedBy = "cliente")
    private List<Fattura> fatture;
    @ManyToOne
    private Indirizzo sedeLegale;
    @ManyToOne
    private Indirizzo sedeOperativa;
    @ManyToOne
    private Tipo tipo;


}
