package org.desafios;

import java.util.*;

public class Desafio8 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        Optional<Integer> somaLista = numeros.stream()
                .reduce((a, b) -> Integer.sum(a, b));// Metodo para agregar os elementos de um stream em um unico resultado

        if (somaLista.isPresent()) {
            System.out.println("A soma eh " + somaLista.get());
        } else System.out.println("A lista esta vazia");
    }
}
