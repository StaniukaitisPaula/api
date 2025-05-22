package br.com.fiap.acolher.service;

import br.com.fiap.acolher.dto.FuncionarioDTO;
import br.com.fiap.acolher.model.Funcionario;
import br.com.fiap.acolher.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public FuncionarioDTO login(String email, String senha) {
        Optional<Funcionario> funcionario = funcionarioRepository.findByEmail(email);

        if (funcionario.isPresent() && passwordEncoder.matches(senha, funcionario.get().getSenha())) {
            return new FuncionarioDTO(funcionario.get());
        }

        return null;
    }
}
