package org.banco.model;

import lombok.Getter;
import org.banco.InterfaceConta;
import org.banco.exceptions.SaldoInsuficienteException;
import org.banco.exceptions.ValorInvalidoException;

import java.math.BigDecimal;

@Getter
public abstract class ContaModel implements InterfaceConta {
    private static final int AGENCIA_DEFAULT = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected BigDecimal saldo;
    protected ClienteModel cliente;
    protected BancoModel banco;

    public ContaModel(ClienteModel cliente, BancoModel banco) {
        this.agencia = AGENCIA_DEFAULT;
        this.numero = SEQUENCIAL;
        SEQUENCIAL++;
        this.saldo = BigDecimal.ZERO;
        this.cliente = cliente;
        this.banco = banco;
    }

    @Override
    public void sacar(BigDecimal valor) throws SaldoInsuficienteException {
        if (valor.compareTo(saldo) > 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar saque.");
        }
        saldo = saldo.subtract(valor);
    }

    @Override
    public void depositar(BigDecimal valor) throws ValorInvalidoException {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValorInvalidoException("Valor de depósito deve ser positivo.");
        }
        saldo = saldo.add(valor);
    }

    @Override
    public void transferir(BigDecimal valor, ContaModel contaDestino) throws SaldoInsuficienteException {
        if (valor.compareTo(saldo) > 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar transferência.");
        }
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Banco: %s", this.banco.getNome()));
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
