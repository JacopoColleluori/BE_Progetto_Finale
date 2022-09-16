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
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sigla;
    private String regione;
    @OneToMany(mappedBy = "provincia")
    private List<Comune> comuni;
}
