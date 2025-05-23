package br.com.fiap.acolher.controller;

import br.com.fiap.acolher.dto.TarefaDTO;
import br.com.fiap.acolher.model.Tarefa;
import br.com.fiap.acolher.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    @Autowired
    private TarefaService service;

    @GetMapping
    public List<Tarefa> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Tarefa> salvar(@RequestBody TarefaDTO dto) {
        Tarefa novaTarefa = service.salvar(dto);
        return ResponseEntity.status(201).body(novaTarefa);
    }

    @GetMapping("/total-horas/{funcionarioId}")
    public Double calcularTotalHoras(@PathVariable Long funcionarioId) {
        return service.calcularTotalHorasGastas(funcionarioId);
    }

    @GetMapping("/notificacao/{funcionarioId}")
    public String verificarNotificacao(@PathVariable Long funcionarioId) {
        boolean excedeu = service.ultrapassouLimite(funcionarioId);
        return excedeu ? "Atenção: total de horas comprometidas excede 8h!" : "Horas comprometidas dentro do limite.";
    }
}

