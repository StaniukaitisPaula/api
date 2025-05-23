package br.com.fiap.acolher.service;

import br.com.fiap.acolher.dto.FuncionarioDTO;
import br.com.fiap.acolher.model.Funcionario;
import br.com.fiap.acolher.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Funcionario> listarTodos() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        System.out.println("Funcionários encontrados: " + funcionarios.size());
        return funcionarios;
    }

    @Transactional
    public FuncionarioDTO criarFuncionario(FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setEmail(dto.getEmail());
        funcionario.setSenha(passwordEncoder.encode(dto.getSenha())); // criptografa a senha
        Funcionario salvo = funcionarioRepository.save(funcionario);
        return new FuncionarioDTO(salvo);
    }



}
