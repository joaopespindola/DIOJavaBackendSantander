package org.map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> produtosMap;

    public EstoqueProdutos() {
        this.produtosMap = new HashMap<>();
    }

    public void adicionarProduto(long codigo, String nome, double preco, int quantidade) {
        produtosMap.put(codigo, new Produto(nome, preco, quantidade));
    }

    public void exibirProdutos() {
        System.out.println(produtosMap);
    }

    public double calcularValorTotalEstoque() {
        double valorTotal = 0;
        if (produtosMap.isEmpty()) {
            System.out.println("Estoque vazio");
            return valorTotal;
        }

        for (Produto produto : produtosMap.values()) { // Metodo values( ) para pegar so os valores
            valorTotal += (produto.getPreco() * produto.getQuantidade());
        }
        return valorTotal;
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if (produtosMap.isEmpty()) {
            System.out.println("Estoque vazio");
            return produtoMaisCaro;
        }

        for (Produto produto : produtosMap.values()) {
            if (produto.getPreco() > maiorPreco) {
                produtoMaisCaro = produto;
            }
        }
        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        if (produtosMap.isEmpty()) {
            System.out.println("Estoque vazio");
            return produtoMaisBarato;
        }

        for (Produto produto : produtosMap.values()) {
            if (produto.getPreco() < menorPreco) {
                menorPreco = produto.getPreco();
                produtoMaisBarato = produto;
            }
        }
        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto produtoMaiorQuantidadeValorTotalNoEstoque = null;
        double maiorQuantidadeValorTotal = 0d;
        if (produtosMap.isEmpty()) {
            System.out.println("Estoque vazio");
        }

        for (Produto produto : produtosMap.values()) {
            if ((produto.getQuantidade() * produto.getPreco()) > maiorQuantidadeValorTotal) {
                maiorQuantidadeValorTotal = produto.getQuantidade() * produto.getPreco();
                produtoMaiorQuantidadeValorTotalNoEstoque = produto;
            }
        }
        return produtoMaiorQuantidadeValorTotalNoEstoque;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.adicionarProduto(1L, "Arroz 5kg", 24.99, 10);
        estoqueProdutos.adicionarProduto(2L, "Feijao 1kg", 11.99, 10);
        estoqueProdutos.adicionarProduto(3L, "Acucar 5kg", 15.99, 20);
        estoqueProdutos.exibirProdutos();

        System.out.println("O valor total do estoque eh: " + estoqueProdutos.calcularValorTotalEstoque());
        System.out.println("O produto mais caro eh: " + estoqueProdutos.obterProdutoMaisCaro());
        System.out.println("O produto com a maior relacao quantidade x valor eh: " + estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
        System.out.println("O produto mais barato eh: " + estoqueProdutos.obterProdutoMaisBarato());
    }
}
