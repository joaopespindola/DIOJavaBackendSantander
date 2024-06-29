package org.map.operacoesbasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String nome, String definicao) {
        dicionarioMap.put(nome, definicao);
    }

    public void removerPalavra(String nome) {
        if (!dicionarioMap.isEmpty()) {
            dicionarioMap.remove(nome);
        } else System.out.println("Dicionario vazio ou palavra nao encontrada");
    }

    public void exibirPalavras() {
        if (!dicionarioMap.isEmpty()) {
            System.out.println(dicionarioMap);
        } else System.out.println("Dicionario vazio");
    }

    public String pesquisarPorPalavra(String palavra) {
        if (dicionarioMap.isEmpty()) {
            System.out.println("O dicionario esta vazio");
        }
        String definicaoPorPalavra = dicionarioMap.get(palavra);
        if (definicaoPorPalavra == null) {
            System.out.println("Palavra nao encontrada");
        }
        return definicaoPorPalavra;
    }


    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("Mesa", "E um movel de madeira");
        dicionario.adicionarPalavra("Cadeira", "E um movel de madeira");
        dicionario.adicionarPalavra(null, "Chave nula");
        dicionario.adicionarPalavra(null, "Chavee nula");
        dicionario.adicionarPalavra("Valor nulo", null);
        dicionario.adicionarPalavra("Valor nulo", null);

        dicionario.exibirPalavras();
        dicionario.removerPalavra(null);
        dicionario.exibirPalavras();

        System.out.println(dicionario.pesquisarPorPalavra("Mesa"));
    }
}
