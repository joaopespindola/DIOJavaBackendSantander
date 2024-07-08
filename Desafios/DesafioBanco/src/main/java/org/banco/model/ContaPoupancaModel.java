package org.banco.model;

public class ContaPoupancaModel extends ContaModel {

    public ContaPoupancaModel(ClienteModel cliente, BancoModel banco) {
        super(cliente, banco);
    }

    public void imprimirExtrato() {
        System.out.println("--- EXTRATO CONTA CORRENTE ---");
        super.imprimirInfosComuns();
    }
}
