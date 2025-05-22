package br.com.fiap.acolher.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TBL_TAREFA")
@Data
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tarefa_seq")
    @SequenceGenerator(name = "tarefa_seq", sequenceName = "SEQ_TAREFA", allocationSize = 1)
    @Column(name = "id_tarefa")
    private Long idTarefa;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "prazo", nullable = false)
    private LocalDate prazo;

    @Column(name = "horas_gastas", nullable = false)
    private Double horasGastas;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", nullable = false)
    private Funcionario funcionario;
}