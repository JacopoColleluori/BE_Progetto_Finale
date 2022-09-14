package com.epicode.project.progettofinale.security.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class RequestRegisterUser {

    private String userName;
    private String password;
    private String email;
    private String nome;
    private String cognome;
    private Set<String> roles = new HashSet<>();
}