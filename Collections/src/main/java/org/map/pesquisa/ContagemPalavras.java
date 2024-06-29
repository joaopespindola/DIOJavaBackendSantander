package org.map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> contagemPalavras;

    public ContagemPalavras() {
        contagemPalavras = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        contagemPalavras.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if (contagemPalavras.isEmpty()) {
            System.out.println("Contagem vazia");
        } else if (contagemPalavras.containsKey(palavra)) {
            contagemPalavras.remove(palavra);
        } else System.out.println("Palavra nao encontrada");
    }

    public void exibirContagemPalavras() {
        // Map nao pode ter chave(palavra) repetida
        System.out.println("O conjunto contem " + contagemPalavras.size() + " palavras");
    }

    public void encontrarPalavraMaisFrequente() {
        int palavraMaisFrequente = Integer.MIN_VALUE;
        String palavra = "";
        if (contagemPalavras.isEmpty()) {
            System.out.println("Contagem vazia");
        }

        // O metodo entry me fornece um único par chave-valor em um mapa
        for (Map.Entry<String, Integer> entry : contagemPalavras.entrySet()) {
            if (palavraMaisFrequente < entry.getValue()) {
                palavraMaisFrequente = entry.getValue();
                palavra = entry.getKey();
            }
        }
        System.out.println("A palavra mais frequente eh " + palavra + " e repete " + palavraMaisFrequente  + " vezes");
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavra = new ContagemPalavras();

        contagemPalavra.adicionarPalavra("Java", 5);
        contagemPalavra.adicionarPalavra("Python", 3);
        contagemPalavra.adicionarPalavra("C++", 2);
        contagemPalavra.adicionarPalavra("JavaScript", 4);

        contagemPalavra.exibirContagemPalavras();

        contagemPalavra.encontrarPalavraMaisFrequente();

        contagemPalavra.removerPalavra("Python");
        contagemPalavra.removerPalavra("Ruby");

        contagemPalavra.exibirContagemPalavras();

        contagemPalavra.encontrarPalavraMaisFrequente();
    }
}
