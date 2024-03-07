package com.aea.aea.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aea.aea.model.Servico;

@RestController
@RequestMapping("Servico")
public class ServicoController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Servico> repository = new ArrayList<>();

    @GetMapping
    public List<Servico> index() {
        return repository;
    }

    @PostMapping
    // @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Servico> create(@RequestBody Servico servico) {
        log.info("cadastrando Servico: {}", servico);
        repository.add(servico);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(servico);
    }

    @GetMapping("{id}")
    public ResponseEntity<Servico> get(@PathVariable Long id) {
        log.info("Buscar por id: {}", id);

        var optionalServico = buscarServicoPorId(id);

        if (optionalServico.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(optionalServico.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        log.info("apagando Servico {}", id);

        var optionalServico = buscarServicoPorId(id);

        if (optionalServico.isEmpty())
            return ResponseEntity.notFound().build();

        repository.remove(optionalServico.get());

        return ResponseEntity.noContent().build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Servico servico){
        log.info("atualizando servico id {} para {}", id, servico);
        
        var optionalServico = buscarServicoPorId(id);

        if (optionalServico.isEmpty())
            return ResponseEntity.notFound().build();

        var servicoEncontrado = optionalServico.get();
        var servicoAtualizado = new Servico(id, servico.nome(), servico.icone());
        repository.remove(servicoEncontrado);
        repository.add(servicoAtualizado);

        return ResponseEntity.ok().body(servicoAtualizado);
    }

    private Optional<Servico> buscarServicoPorId(Long id) {
        var optionalServico = repository
                .stream()
                .filter(c -> c.id().equals(id))
                .findFirst();
        return optionalServico;
    }

}