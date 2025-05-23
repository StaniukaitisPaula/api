package br.com.fiap.acolher.repository;

import br.com.fiap.acolher.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByFuncionarioIdFuncionario(Long idFuncionario);

    @Query("SELECT SUM(t.horasGastas) FROM Tarefa t WHERE t.funcionario.idFuncionario = :funcionarioId")
    Double calcularTotalHorasGastas(@Param("funcionarioId") Long funcionarioId);
}
