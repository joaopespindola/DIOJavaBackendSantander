package org.banco.model;

import lombok.Getter;

@Getter
public class Cliente {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }
}
