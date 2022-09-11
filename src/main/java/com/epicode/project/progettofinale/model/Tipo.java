package com.epicode.project.progettofinale.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Tipo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private EnumTipo tipo;
    @OneToMany(mappedBy="tipo")
    private List<Cliente> clienti;
}
