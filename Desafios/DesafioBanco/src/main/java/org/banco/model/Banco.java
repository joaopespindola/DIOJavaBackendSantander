package org.banco.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public Conta criarConta(Cliente titular, Class<? extends Conta> tipoConta){// "Class<? extends Conta>" generics com coringa
        Conta conta;
        if (tipoConta == ContaCorrente.class) {
            conta = new ContaCorrente(titular, this);
        } else if (tipoConta == ContaPoupanca.class) {
            conta = new ContaPoupanca(titular, this);
        } else {
            throw new IllegalArgumentException("Tipo de conta desconhecido");
        }
        contas.add(conta);
        System.out.println("Conta criada com sucesso!");
        return conta;
    }

    public void exibirContas() {
        if(contas.isEmpty()){
            System.out.println("Nenhuma conta encontrada.");
        }
        for (Conta conta : contas) {
            conta.imprimirExtrato();
            System.out.println("\n");
        }
    }

    public Conta getConta(int numero) {
        return contas.get(numero - 1);
    }
}
