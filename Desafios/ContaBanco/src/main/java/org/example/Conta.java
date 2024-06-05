package org.example;

import java.math.BigDecimal;

public class Conta {

    private int numero;
    private String agencia;
    private String nomeCliente;
    private BigDecimal saldo;

    public Conta(int numero, String agencia, String nomeCliente, BigDecimal saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    public String imprimeExtrato(){
        return ("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " +
                        agencia + ", conta " + numero + " e seu saldo " + saldo + " já está disponível para saque");
    }

    public int getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
