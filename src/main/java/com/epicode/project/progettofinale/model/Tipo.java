package com.epicode.project.progettofinale.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @Enumerated(EnumType.STRING)
    private EnumTipo tipo;
    @JsonIgnore
    @OneToMany(mappedBy = "tipo")
    private List<Cliente> clienti;
}
