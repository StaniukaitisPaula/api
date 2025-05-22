package br.com.fiap.acolher.repository;

import br.com.fiap.acolher.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByEmailAndSenha(String email, String senha);
    Optional<Funcionario> findByEmail(String email);
}
