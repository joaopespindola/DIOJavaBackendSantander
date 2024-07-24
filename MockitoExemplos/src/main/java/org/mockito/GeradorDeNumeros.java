package org.mockito;

import java.util.List;
import java.util.SplittableRandom;
import java.util.stream.Collectors;

public final class GeradorDeNumeros {

    private static SplittableRandom random = new SplittableRandom();

    private GeradorDeNumeros(){
    }

    public static List<Integer> geraNumerosAleatorios(int tamanhoLista) {
        return random.ints().boxed().limit(tamanhoLista).collect(Collectors.toList());
    }

}
