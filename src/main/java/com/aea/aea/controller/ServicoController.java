package com.aea.aea.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import java.util.List;

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
import lombok.extern.slf4j.Slf4j;;

@RestController
@RequestMapping("Servico")
@Slf4j
public class ServicoController {

    @Autowired
    ServicoRepository ServicoRepository;

    @GetMapping
    public List<Servico> index() {
        return ServicoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Servico create(@RequestBody Servico servico) {
        log.info("cadastrando serviço: {}", servico);
        return ServicoRepository.save(servico);
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
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("apagando serviço {}", id);

        verificarSeExisteServico(id);

        ServicoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Servico update(@PathVariable Long id, @RequestBody Servico servico) {
        log.info("atualizando servico id {} para {}", id, servico);

        verificarSeExisteServico(id);

        servico.setId(id);
        return ServicoRepository.save(servico);
    }

    private void verificarSeExisteServico(Long id) {
        ServicoRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Servico não encontrada"));
    }

}