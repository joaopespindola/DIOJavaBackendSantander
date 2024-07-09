package org.banco;

import org.banco.exceptions.SaldoInsuficienteException;
import org.banco.exceptions.ValorInvalidoException;
import org.banco.model.Conta;

import java.math.BigDecimal;

public interface InterfaceConta {
    void sacar(BigDecimal valor) throws SaldoInsuficienteException;
    void depositar(BigDecimal valor) throws ValorInvalidoException;
    void transferir(BigDecimal valor, Conta contaDestino) throws SaldoInsuficienteException;
    void imprimirExtrato();
}
