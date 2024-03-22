package com.aea.aea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aea.aea.model.Agendamento;

public interface AgendamentoRepository
        extends JpaRepository<Agendamento, Long> {

}
