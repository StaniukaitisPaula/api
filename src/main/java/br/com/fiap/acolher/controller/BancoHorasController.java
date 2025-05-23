package br.com.fiap.acolher.controller;

import br.com.fiap.acolher.dto.BancoHorasDT0;
import br.com.fiap.acolher.model.BancoHoras;
import br.com.fiap.acolher.service.BancoHorasService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/banco-horas")
@RequiredArgsConstructor
public class BancoHorasController {

    @Autowired
    private BancoHorasService service;

    @GetMapping
    public List<BancoHoras> listar() {
        return service.listar();
    }

    @PostMapping
    public BancoHoras salvar(@RequestBody BancoHorasDT0 dto) {
        return service.salvar(dto);
    }

    @GetMapping("/saldo/{funcionarioId}")
    public Double calcularSaldoHoras(@PathVariable Long funcionarioId) {
        return service.calcularSaldoHoras(funcionarioId);
    }
}
