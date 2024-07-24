package org.banco.view;

import org.banco.exceptions.SaldoInsuficienteException;
import org.banco.model.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class BancoView {
    public static void main(String[] args) {
        Banco banco = new Banco("Santander");
        Cliente clienteJoao = new Cliente("Joao");// TO-DO feature para ter mais clientes
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            exibirMenu();
            int escolha = scanner.nextInt();
            int numeroConta;
            scanner.nextLine(); // Limpar o buffer do scanner

            try {
                switch (escolha) {
                    case 1:
                        banco.criarConta(clienteJoao, ContaCorrente.class);
                        break;
                    case 2:
                        banco.criarConta(clienteJoao, ContaPoupanca.class);
                        break;
                    case 3:
                        numeroConta = solicitarNumeroConta(scanner);
                        System.out.println("Qual o valor que deseja depositar? ");
                        BigDecimal valorDepositado = scanner.nextBigDecimal();

                        banco.getConta(numeroConta).depositar(valorDepositado);
                        break;
                    case 4:
                        numeroConta = solicitarNumeroConta(scanner);
                        System.out.println("Qual o valor que deseja sacar? ");
                        BigDecimal valorSacado = lerValor(scanner);

                        banco.getConta(numeroConta).sacar(valorSacado);
                        break;
                    case 5:
                        System.out.println("Digite o número da sua conta: ");
                        int numeroContaOrigem = scanner.nextInt();
                        System.out.println("Digite o número da conta de destino: ");
                        int numeroContaDestino = scanner.nextInt();
                        System.out.println("Qual o valor que deseja transferir? ");
                        BigDecimal valorTransferido = lerValor(scanner);

                        Conta contaOrigem = banco.getConta(numeroContaOrigem);
                        Conta contaDestino = banco.getConta(numeroContaDestino);

                        contaOrigem.transferir(valorTransferido, contaDestino);
                        System.out.println("Transferência realizada com sucesso!");
                        break;

                    case 6:
                        System.out.println("Digite o número da sua conta: ");
                        numeroConta = scanner.nextInt();
                        banco.getConta(numeroConta).imprimirExtrato();
                        break;
                    case 7:
                        banco.exibirContas();
                        break;
                    case 8:
                        running = false;
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (SaldoInsuficienteException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Erro ao ler entrada numérica: " + e.getMessage());
                scanner.nextLine(); // Limpar o buffer do scanner para evitar loop infinito
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--- Meu Banco Digital ---");
        System.out.println("1. Criar Conta Corrente");
        System.out.println("2. Criar Conta Poupança");
        System.out.println("3. Depositar");
        System.out.println("4. Sacar");
        System.out.println("5. Transferir");
        System.out.println("6. Exibir Extrato");
        System.out.println("7. Exibir Todas as Contas");
        System.out.println("8. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int solicitarNumeroConta(Scanner scanner) {
        System.out.println("Digite o número da conta: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número de conta válido.");
            scanner.nextLine();
        }
        return scanner.nextInt();
    }

    private static BigDecimal lerValor(Scanner scanner) {
        while (!scanner.hasNextBigDecimal()) {
            System.out.println("Por favor, insira um valor numérico válido.");
            scanner.nextLine();
        }
        return scanner.nextBigDecimal();
    }
}
