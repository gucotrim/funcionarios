package com.meli.funcionarios.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Document(indexName = "funcionarios")
public class Funcionario {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String nome;

    @Field(type = FieldType.Text)
    private String sobrenome;

    @Field(type = FieldType.Integer)
    private int idade;

    @Field(type = FieldType.Nested, includeInParent = true)
    private Endereco endereco;
}
