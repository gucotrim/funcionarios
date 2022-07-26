package com.meli.funcionarios.service;

import com.meli.funcionarios.domain.Endereco;
import com.meli.funcionarios.domain.Funcionario;
import com.meli.funcionarios.dto.FuncionarioDto;
import com.meli.funcionarios.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService implements FuncionarioServiceInterface{

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Funcionario save(FuncionarioDto funcionarioDto) {
        return repository.save(Funcionario.builder()
                .nome(funcionarioDto.getNome())
                .sobrenome(funcionarioDto.getSobrenome())
                .idade(funcionarioDto.getIdade())
                .endereco(funcionarioDto.getEndereco())
                .build());
    }

    @Override
    public Optional<Funcionario> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Funcionario> findAllAsList() {
        return repository.findAllAsList();
    }

    @Override
    public Funcionario update(String id, Funcionario funcionario, FuncionarioDto funcionarioDto) {
        funcionario.setNome(funcionarioDto.getNome());
        funcionario.setSobrenome(funcionarioDto.getSobrenome());
        funcionario.setIdade(funcionarioDto.getIdade());
        funcionario.setEndereco(funcionarioDto.getEndereco());
        return repository.save(funcionario);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
