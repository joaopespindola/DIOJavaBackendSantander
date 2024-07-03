package org.desafios;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Desafio3 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        Predicate<Integer> EhPositivo = numero -> numero > 0;
        boolean todosPositivos = numeros.stream()
                .allMatch(EhPositivo);// Verifica se todos os elementos satisfazem o predicate em questão

        if (todosPositivos) {
            System.out.println("Todos os numeros sao positivos");
        } else System.out.println("Existem numeros nao positivos");
    }

}
