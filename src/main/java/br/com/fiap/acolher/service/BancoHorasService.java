package br.com.fiap.acolher.service;

import br.com.fiap.acolher.dto.BancoHorasDT0;
import br.com.fiap.acolher.model.BancoHoras;
import br.com.fiap.acolher.repository.BancoHorasRepository;
import br.com.fiap.acolher.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BancoHorasService {

    @Autowired
    private BancoHorasRepository repository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<BancoHoras> listar() {
        return repository.findAll();
    }

    public BancoHoras salvar(BancoHorasDT0 dto) {
        var funcionario = funcionarioRepository.findById(dto.getIdFuncionario())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        var bancoHoras = new BancoHoras();
        bancoHoras.setData(dto.getData());
        bancoHoras.setHorasExtras(dto.getHorasExtras());
        bancoHoras.setHorasPagas(dto.getHorasPagas());
        bancoHoras.setFuncionario(funcionario);

        return repository.save(bancoHoras);
    }

    public Double calcularSaldoHoras(Long funcionarioId) {
        return Optional.ofNullable(repository.calcularSaldoHoras(funcionarioId)).orElse(0.0);
    }
}
