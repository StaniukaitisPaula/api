package br.com.fiap.acolher.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TBL_BANCO_HORAS")
@Data
public class BancoHoras {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "banco_horas_seq")
    @SequenceGenerator(name = "banco_horas_seq", sequenceName = "SEQ_BANCO_HORAS", allocationSize = 1)
    @Column(name = "id_banco_horas")
    private Long idBancoHoras;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "horas_extras", nullable = false)
    private Double horasExtras;

    @Column(name = "horas_pagas", nullable = false)
    private Double horasPagas;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", nullable = false)
    private Funcionario funcionario;
}