package com.meli.funcionarios.controller;

import com.meli.funcionarios.domain.Funcionario;
import com.meli.funcionarios.dto.FuncionarioDto;
import com.meli.funcionarios.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Funcionario> save(@RequestBody FuncionarioDto funcionarioDto) {
        return new ResponseEntity<>(service.save(funcionarioDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable String id) {
        return service.findById(id)
                .map(func -> ResponseEntity.ok(func))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAllAsList() {
        return ResponseEntity.ok(service.findAllAsList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable String id, @RequestBody FuncionarioDto funcionarioDto) {
        return service.findById(id)
                .map(func -> ResponseEntity.ok(service.update(id, func, funcionarioDto)))
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return service.findById(id)
                .map(func -> {
                    service.delete(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
