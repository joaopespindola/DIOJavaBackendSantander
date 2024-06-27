package org.set.operacoesbasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicas;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicas = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        palavrasUnicas.add(palavra);
    }

    public void verificarPalavra(String palavra){
        if(palavrasUnicas.contains(palavra)){
            System.out.println("Contem " + palavra);
        } else System.out.println("Nao contem " + palavra);
    }

    public void removerPalavra(String palavra) {
        if (palavrasUnicas.contains(palavra)) {
            palavrasUnicas.remove(palavra);
        } else System.out.println("O conjunto nao contem a palavra");
    }

    public void exibirPalavrasUnicas(){
        System.out.println(palavrasUnicas);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        conjuntoPalavrasUnicas.adicionarPalavra("Banana");
        conjuntoPalavrasUnicas.adicionarPalavra("Maca");
        conjuntoPalavrasUnicas.adicionarPalavra("Pera");
        conjuntoPalavrasUnicas.adicionarPalavra("Batata");
        conjuntoPalavrasUnicas.adicionarPalavra("Pera"); // Mesmo sem sobreescrever o metodo equals ele ja nao adiciona o elemento repetido

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();
        conjuntoPalavrasUnicas.verificarPalavra("Pera");
        conjuntoPalavrasUnicas.removerPalavra("Pera");
        conjuntoPalavrasUnicas.exibirPalavrasUnicas();
    }
}
