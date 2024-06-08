package org.joaopespindola;

import org.joaopespindola.Exceptions.ParametrosInvalidosException;

import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int[] numeros = receberNumeros(scanner);
            contar(numeros[0], numeros[1]);
        } catch (ParametrosInvalidosException exception) {
            System.out.println(exception.getMessage());
        }
    }

    //Abstração do recebimento de números para simplificar a main
    static int[] receberNumeros(Scanner scanner) {
        System.out.println("Digite o primeiro parâmetro");
        int numeroUm = scanner.nextInt();
        System.out.println("Digite o segundo parâmetro");
        int numeroDois = scanner.nextInt();
        return new int[]{numeroUm, numeroDois};
    }

    static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
        if(parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        } else if(parametroUm == parametroDois) { //Condição adicional que decidi colocar para cobrir a situação em que os números são iguais
            throw new ParametrosInvalidosException("Os parâmetros não podem ser iguais");
        }
        int contagem = parametroDois - parametroUm;
        for(int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}