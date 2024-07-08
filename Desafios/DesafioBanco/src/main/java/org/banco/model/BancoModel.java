package org.banco.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BancoModel {
    private String nome;
    private List<ContaModel> contas;

    public BancoModel(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public ContaModel criarConta(ClienteModel titular, Class<? extends ContaModel> tipoConta){// "Class<? extends Conta>" generics com coringa
        ContaModel conta;
        if (tipoConta == ContaCorrenteModel.class) {
            conta = new ContaCorrenteModel(titular, this);
        } else if (tipoConta == ContaPoupancaModel.class) {
            conta = new ContaPoupancaModel(titular, this);
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
        for (ContaModel conta : contas) {
            conta.imprimirExtrato();
            System.out.println("\n");
        }
    }

    public ContaModel getConta(int numero) {
        return contas.get(numero - 1);
    }
}
