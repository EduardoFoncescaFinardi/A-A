package com.aea.aea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aea.aea.model.Agendamento;
import com.aea.aea.repository.AgendamentoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("agendamento")
public class AgendamentoController {

    @Autowired
    AgendamentoRepository repository;

    @PostMapping
    public Agendamento create(@RequestBody @Valid Agendamento agendamento) {
        return repository.save(agendamento);
    }

}
