package org.desafios;

import java.util.Arrays;
import java.util.List;

public class Desafio6 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        boolean temMaiorQueDez = numeros.stream()
                .anyMatch(numero -> numero > 10);// Verifica se ao menos um elemento satisfaz a condicao

        if (temMaiorQueDez) {
            System.out.println("Tem maior que dez");
        } else System.out.println("Nao tem maior que dez");
    }
}
