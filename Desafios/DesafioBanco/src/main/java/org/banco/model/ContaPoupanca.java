package org.banco.model;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente, Banco banco) {
        super(cliente, banco);
    }

    public void imprimirExtrato() {
        System.out.println("--- EXTRATO CONTA CORRENTE ---");
        super.imprimirInfosComuns();
    }
}
