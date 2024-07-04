package org.desafios;

import java.util.Arrays;
import java.util.List;

public class Desafio9 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        boolean saoDistintos = numeros.stream().distinct().count() == numeros.size();// Verifica se o numero de elementos
                                                                                    // distintos eh o mesmo numero de elementos na lista numeros

        if (saoDistintos) {
            System.out.println("Sao distintos");
        }else{
            System.out.println("Nao distintos");
        }
    }
}
