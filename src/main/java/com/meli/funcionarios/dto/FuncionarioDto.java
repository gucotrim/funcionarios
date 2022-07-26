package com.meli.funcionarios.dto;

import com.meli.funcionarios.domain.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class FuncionarioDto {

    private String nome;

    private String sobrenome;

    private int idade;

    private Endereco endereco;
}
