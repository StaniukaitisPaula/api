package br.com.fiap.acolher.dto;

import br.com.fiap.acolher.model.Funcionario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FuncionarioDTO {
    private Long idFuncionario;
    private String email;

    public FuncionarioDTO(Funcionario funcionario) {
        this.idFuncionario = funcionario.getIdFuncionario();
        this.email = funcionario.getEmail();
    }
}