package org.example;

import org.example.Conta;
import org.example.exceptions.AgenciaInvalidaException;
import org.example.exceptions.NomeClienteInvalidoException;
import org.example.exceptions.NumeroContaInvalidoException;

import java.math.BigDecimal;
import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int escolha;
        Conta conta;

        do {
            System.out.println("Seja bem-vindo ao nosso banco, para prosseguir, escolha uma das opções abaixo!");
            System.out.println("Para criar uma conta, digite 1");
            System.out.println("Para sair, digite 2");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    conta = criarContaDoUsuario(scanner);
                    if (conta != null) {
                    System.out.printf(conta.imprimeExtrato());
                    System.out.println("\nVoltando para o menu...");
                    Thread.sleep(2000);
                    }
                    break;
                case 2:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    Thread.sleep(2000);
            }
        } while(escolha != 2);
        scanner.close();
    }

    public static Conta criarContaDoUsuario(Scanner scanner){
        try {
            scanner.nextLine();
            System.out.println("Para começarmos, qual o seu nome?");
            String nomeCliente = scanner.nextLine();
            if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
                throw new NomeClienteInvalidoException("o nome do cliente não pode ser vazio.");
            }

            System.out.println("Qual o nome da sua agência?");
            String agencia = scanner.nextLine();
            if (agencia == null || agencia.trim().isEmpty()) {
                throw new AgenciaInvalidaException("o nome da agência não pode ser vazio.");
            }

            System.out.println("Qual o número da sua conta?");
            int numero = scanner.nextInt();
            if (numero <= 0) {
                throw new NumeroContaInvalidoException("o número da conta deve ser positivo.");
            }

            System.out.println("Qual o saldo da sua conta?");
            BigDecimal saldo = new BigDecimal(scanner.next());
            return new Conta(numero, agencia, nomeCliente, saldo);
        } catch (Exception e) {
            System.out.println("Não foi possível criar a conta pois " + e.getMessage());
            throw new RuntimeException();
        }
    }
}
