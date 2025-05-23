package br.com.fiap.acolher.repository;

import br.com.fiap.acolher.model.AvaliacaoClima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoClimaRepository extends JpaRepository<AvaliacaoClima, Long> {

    List<AvaliacaoClima> findByFuncionarioIdFuncionarioOrderByDataRespostaDesc(Long funcionarioId);
}
