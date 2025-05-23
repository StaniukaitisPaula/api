package br.com.fiap.acolher.dto;

import lombok.Data;

import java.time.LocalDate;

import br.com.fiap.acolher.model.AvaliacaoClima;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AvaliacaoClimaDTO {

    private Long idAvaliacao;
    private LocalDate dataResposta;
    private Double percentualRisco;
    private Double percentualCargaTrabalho;
    private Double percentualSinaisAlerta;
    private String diagnosticoClima;
    private Long idFuncionario;

    public AvaliacaoClimaDTO(AvaliacaoClima avaliacao) {
        this.idAvaliacao = avaliacao.getId();
        this.dataResposta = avaliacao.getDataResposta();
        this.percentualRisco = avaliacao.getPercentualRisco();
        this.percentualCargaTrabalho = avaliacao.getPercentualCargaTrabalho();
        this.percentualSinaisAlerta = avaliacao.getPercentualSinaisAlerta();
        this.diagnosticoClima = avaliacao.getDiagnosticoClima();
        this.idFuncionario = avaliacao.getFuncionario().getIdFuncionario();
    }
}
