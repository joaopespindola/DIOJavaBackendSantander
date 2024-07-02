package org.desafios;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Desafio1 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        numeros.stream() // Transformando a List em um objeto do tipo Stream
                .sorted() // Ordenando o Stream
                .forEach(System.out::println); // Iterando sobre o Stream
    }
}