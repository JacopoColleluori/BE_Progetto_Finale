package com.epicode.project.progettofinale.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Indirizzo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String via;
    public int civico;
    private String localita;
    private int cap;
    @ManyToOne
    private Comune comune;
    @OneToMany(mappedBy="sedeLegale")
    private List<Cliente> clientiSedeLegale;
    @OneToMany(mappedBy="sedeOperativa")
    private List<Cliente> clientiSedeOperativa;
}
