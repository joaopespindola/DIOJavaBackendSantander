package org.apple;

import org.apple.dispositivos.iPhone;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        iPhone meuIPhone = new iPhone();
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("Escolha um aplicativo para abrir:");
            System.out.println("1. Reprodutor Musical");
            System.out.println("2. Aparelho Telefônico");
            System.out.println("3. Navegador na Internet");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    menuReprodutorMusical(meuIPhone, scanner);
                    break;
                case 2:
                    menuAparelhoTelefonico(meuIPhone, scanner);
                    break;
                case 3:
                    menuNavegadorInternet(meuIPhone, scanner);
                    break;
                case 4:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }

    private static void menuReprodutorMusical(iPhone meuIPhone, Scanner scanner) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("Reprodutor Musical:");
            System.out.println("1. Tocar música");
            System.out.println("2. Pausar música");
            System.out.println("3. Selecionar música");
            System.out.println("4. Voltar ao menu principal");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    meuIPhone.tocar();
                    break;
                case 2:
                    meuIPhone.pausar();
                    break;
                case 3:
                    System.out.print("Digite o nome da música: ");
                    String musica = scanner.nextLine();
                    meuIPhone.selecionarMusica(musica);
                    break;
                case 4:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        }
    }

    private static void menuAparelhoTelefonico(iPhone meuIPhone, Scanner scanner) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("Aparelho Telefônico:");
            System.out.println("1. Ligar");
            System.out.println("2. Atender chamada");
            System.out.println("3. Iniciar correio de voz");
            System.out.println("4. Voltar ao menu principal");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número para ligar: ");
                    String numero = scanner.nextLine();
                    meuIPhone.ligar(numero);
                    break;
                case 2:
                    meuIPhone.atender();
                    break;
                case 3:
                    meuIPhone.iniciarCorreioVoz();
                    break;
                case 4:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        }
    }

    private static void menuNavegadorInternet(iPhone meuIPhone, Scanner scanner) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("Navegador na Internet:");
            System.out.println("1. Exibir página");
            System.out.println("2. Adicionar nova aba");
            System.out.println("3. Atualizar página");
            System.out.println("4. Voltar ao menu principal");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a URL da página: ");
                    String url = scanner.nextLine();
                    meuIPhone.exibirPagina(url);
                    break;
                case 2:
                    meuIPhone.adicionarNovaAba();
                    break;
                case 3:
                    meuIPhone.atualizarPagina();
                    break;
                case 4:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        }
    }
}

