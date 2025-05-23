package br.com.fiap.acolher.dto;

import br.com.fiap.acolher.model.Funcionario;
import br.com.fiap.acolher.model.Tarefa;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class TarefaDTO {

    private Long idTarefa;
    private String descricao;
    private LocalDate prazo;
    private Double horasGastas;
    private Long idFuncionario;

    public TarefaDTO(Tarefa tarefa) {
        this.idTarefa = tarefa.getIdTarefa();
        this.descricao = tarefa.getDescricao();
        this.prazo = tarefa.getPrazo();
        this.horasGastas = tarefa.getHorasGastas();
        this.idFuncionario = tarefa.getFuncionario().getIdFuncionario();
    }

}