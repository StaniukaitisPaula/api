package br.com.fiap.acolher.service;

import br.com.fiap.acolher.dto.TarefaDTO;
import br.com.fiap.acolher.model.Funcionario;
import br.com.fiap.acolher.model.Tarefa;
import br.com.fiap.acolher.repository.FuncionarioRepository;
import br.com.fiap.acolher.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Tarefa> listar() {
        return repository.findAll();
    }

    public Tarefa salvar(TarefaDTO dto) {
        Funcionario funcionario = funcionarioRepository.findById(dto.getIdFuncionario())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setPrazo(dto.getPrazo());
        tarefa.setHorasGastas(dto.getHorasGastas());
        tarefa.setFuncionario(funcionario);

        return repository.save(tarefa);
    }

    public Double calcularTotalHorasGastas(Long funcionarioId) {
        return Optional.ofNullable(repository.calcularTotalHorasGastas(funcionarioId)).orElse(0.0);
    }

    public boolean ultrapassouLimite(Long funcionarioId) {
        return calcularTotalHorasGastas(funcionarioId) > 8.0;
    }
}

