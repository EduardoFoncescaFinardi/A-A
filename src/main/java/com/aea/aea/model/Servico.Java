package com.aea.aea.model;

import java.util.Random;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

public record Servico(Long id, String nome, String icone) {
@Data
@Entity
public class Servico {
    public Servico(Long id, String nome, String icone){
        var key = (id != null) ? id : Math.abs( new Random().nextLong() );
        this.id = key;
        this.icone = icone;
        this.nome = nome;
    }
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String icone;

} 

}