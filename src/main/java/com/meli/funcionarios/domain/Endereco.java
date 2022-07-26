package com.meli.funcionarios.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class Endereco {

    private String cidade;

    private String estado;
}
