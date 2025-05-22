package br.com.fiap.acolher.controller;

import br.com.fiap.acolher.dto.FuncionarioDTO;
import br.com.fiap.acolher.dto.LoginRequest;
import br.com.fiap.acolher.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        FuncionarioDTO funcionario = service.login(request.getEmail(), request.getSenha());

        if (funcionario != null) {
            return ResponseEntity.ok(funcionario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha inválidos");
        }
    }
}
