package com.meli.funcionarios.service;

import com.meli.funcionarios.domain.Funcionario;
import com.meli.funcionarios.dto.FuncionarioDto;

import java.util.List;
import java.util.Optional;

public interface FuncionarioServiceInterface {
    Funcionario save(FuncionarioDto funcionarioDto);
    Optional<Funcionario> findById(String id);
    List<Funcionario> findAllAsList();
    Funcionario update(String id, Funcionario funcionario, FuncionarioDto funcionarioDto);
    void delete(String id);
}
