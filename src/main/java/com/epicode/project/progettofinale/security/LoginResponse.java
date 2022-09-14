package com.epicode.project.progettofinale.security;

import lombok.Data;

import java.util.List;

@Data
public class LoginResponse {

    private final String type = "Bearer";
    private String token;
    private List<String> roles;

}