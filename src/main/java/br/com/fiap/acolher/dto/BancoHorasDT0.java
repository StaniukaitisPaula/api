package br.com.fiap.acolher.dto;

import br.com.fiap.acolher.model.BancoHoras;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BancoHorasDT0 {

    private Long idBancoHoras;
    private LocalDate data;
    private Double horasExtras;
    private Double horasPagas;
    private Long idFuncionario;

    public BancoHorasDT0(BancoHoras bancoHoras) {
        this.idBancoHoras = bancoHoras.getIdBancoHoras();
        this.data = bancoHoras.getData();
        this.horasExtras = bancoHoras.getHorasExtras();
        this.horasPagas = bancoHoras.getHorasPagas();
        this.idFuncionario = bancoHoras.getFuncionario().getIdFuncionario();
    }
}
