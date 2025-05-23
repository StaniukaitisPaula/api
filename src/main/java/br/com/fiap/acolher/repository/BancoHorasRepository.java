package br.com.fiap.acolher.repository;

import br.com.fiap.acolher.model.BancoHoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BancoHorasRepository extends JpaRepository<BancoHoras, Long> {

    List<BancoHoras> findByFuncionarioIdFuncionario(Long funcionarioId);

    @Query("SELECT SUM(b.horasExtras - b.horasPagas) FROM BancoHoras b WHERE b.funcionario.idFuncionario = :funcionarioId")
    Double calcularSaldoHoras(@Param("funcionarioId") Long funcionarioId);
}
