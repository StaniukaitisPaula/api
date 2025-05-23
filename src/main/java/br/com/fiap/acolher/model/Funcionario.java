package br.com.fiap.acolher.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_FUNCIONARIO")
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Long idFuncionario;


    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;
}
