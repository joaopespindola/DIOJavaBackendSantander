package org.desafios;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;

public class Desafio5 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        // Precisa ser do tipo OptionalDouble pois podemos ter nulo como retorno, então para evitar NullPointerException
        OptionalDouble mediaDosMaioresQueCinco = numeros.stream()
                .filter(n -> n > 5)
                .mapToDouble(Integer::doubleValue)// Conversao de um Integer para double
                .average();// Metodo pronto para calcular a media

        if (mediaDosMaioresQueCinco.isPresent()) {
            System.out.println(mediaDosMaioresQueCinco.getAsDouble());
        } else System.out.println("Nao ha numeros maiores que 5 na lista");
    }
}
