package org.banco.model;

import lombok.Getter;

@Getter
public class ClienteModel {
    private String nome;

    public ClienteModel(String nome) {
        this.nome = nome;
    }
}
