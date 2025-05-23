package br.com.fiap.acolher.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TBL_AVALIACAO_CLIMA")
@Data
public class AvaliacaoClima {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "avaliacao_seq")
    @SequenceGenerator(name = "avaliacao_seq", sequenceName = "SEQ_AVALIACAO_CLIMA", allocationSize = 1)
    private Long id;

    @Column(name = "data_resposta", nullable = false)
    private LocalDate dataResposta;

    @Column(name = "percentual_risco")
    private Double percentualRisco;

    @Column(name = "percentual_carga_trabalho")
    private Double percentualCargaTrabalho;

    @Column(name = "percentual_sinais_alerta")
    private Double percentualSinaisAlerta;

    @Column(name = "diagnostico_clima")
    private String diagnosticoClima;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;
}
