package com.aea.aea.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.aea.aea.model.Servico;
import com.aea.aea.repository.ServicoRepository;

@RestController
@RequestMapping("Servico")


public class ServicoController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ServicoRepository ServicoRepository;

    @GetMapping
    public List<Servico> index() {
        return ServicoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Servico create(@RequestBody Servico servico) {
    ServicoRepository.save(servico);
    return servico;
    }

    @GetMapping("{id}")
    public ResponseEntity<Servico> get(@PathVariable Long id) {
        log.info("Buscar por id: {}", id);

        return ServicoRepository
        .findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        log.info("apagando servico {}", id);

        verificarSeExisteServico(id);

        ServicoRepository.deleteById(id);
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

    private void verificarSeExisteServico(Long id) {
        ServicoRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Servico não encontrada" )
            );
    }


}