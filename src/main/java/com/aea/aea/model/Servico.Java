package com.aea.aea.model;

import java.util.Random;

public record Servico(Long id, String nome, String icone) {

    public Servico(Long id, String nome, String icone){
        var key = (id != null) ? id : Math.abs( new Random().nextLong() );
        this.id = key;
        this.icone = icone;
        this.nome = nome;
    }

} 