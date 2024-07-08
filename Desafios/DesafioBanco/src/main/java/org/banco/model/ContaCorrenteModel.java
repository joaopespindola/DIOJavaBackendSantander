package org.banco.model;

public class ContaCorrenteModel extends ContaModel {

    public ContaCorrenteModel(ClienteModel cliente, BancoModel banco) {
        super(cliente, banco);
    }

    public void imprimirExtrato() {
        System.out.println("--- EXTRATO CONTA CORRENTE ---");
        super.imprimirInfosComuns();
    }
}
