package org.banco.model;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente, Banco banco) {
        super(cliente, banco);
    }

    public void imprimirExtrato() {
        System.out.println("--- EXTRATO CONTA CORRENTE ---");
        super.imprimirInfosComuns();
    }
}
