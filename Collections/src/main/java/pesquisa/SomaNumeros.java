package pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> numeros;

    public SomaNumeros() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        numeros.add(numero);
        numeros.sort(Integer::compare);
    }

    public int calcularSoma(){
        int soma = 0;
        if(!numeros.isEmpty()) {
            for (Integer numero : numeros) {
                soma += numero;
            }
            return soma;
        } else{
            throw new RuntimeException("Lista vazia!");
        }
    }

    public int encontrarMaiorNumero(){
        if(!numeros.isEmpty()) {
            return numeros.getLast();
        } else{
            throw new RuntimeException("Lista Vazia!");
        }
    }

    public int encontrarMenorNumero(){
        if(!numeros.isEmpty()) {
            return numeros.getFirst();
        } else{
            throw new RuntimeException("Lista Vazia!");
        }
    }

    public List<Integer> exibirNumeros() {
        if(!numeros.isEmpty()) {
            return numeros;
        } else{
            throw new RuntimeException("Lista Vazia!");
        }
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(0);
        somaNumeros.adicionarNumero(1);
        somaNumeros.adicionarNumero(1);
        somaNumeros.adicionarNumero(3);
        somaNumeros.adicionarNumero(1);

        try {
            System.out.println(somaNumeros.calcularSoma());
            System.out.println(somaNumeros.encontrarMaiorNumero());
            System.out.println(somaNumeros.encontrarMenorNumero());
            System.out.println(somaNumeros.exibirNumeros());
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
    }
}
