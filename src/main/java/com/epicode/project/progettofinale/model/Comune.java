package com.epicode.project.progettofinale.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeComune;
    private String nomeProvincia;
    @ManyToOne
    private Provincia provincia;
    @OneToMany(mappedBy = "comune")
    private List<Indirizzo> indirizzi;
}
