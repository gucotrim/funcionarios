package com.meli.funcionarios.repository;

import com.meli.funcionarios.domain.Funcionario;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends ElasticsearchRepository<Funcionario, String> {
    @Query("{\"match_all\": {} }")
    List<Funcionario> findAllAsList();
}
