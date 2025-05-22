package br.com.fiap.acolher.dto;


import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String senha;
}