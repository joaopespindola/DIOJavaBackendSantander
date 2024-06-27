package org.set.ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> produtosSet;

    public CadastroProdutos() {
        this.produtosSet = new HashSet<>();
    }

    public void adicionarProduto(long codigo, String nome, double preco, int quantidade) {
        produtosSet.add(new Produto(nome, codigo, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {
        Set<Produto> produtosPorNome = new TreeSet<>(produtosSet); // Atraves do comparable
        return produtosPorNome;
        }

    public Set<Produto> exibirProdutosPorPreco() {
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());// Para o TreeSet posso passar
                                                                                // um Comparator que indicará como quero
                                                                                // que organize os elementos do set
        produtosPorPreco.addAll(produtosSet);
        return produtosPorPreco;
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.adicionarProduto(1L, "Toddy", 9.99,10);
        cadastroProdutos.adicionarProduto(2L, "Nescau", 10.99,10);
        cadastroProdutos.adicionarProduto(2L, "Italac", 5.99,10);
        cadastroProdutos.adicionarProduto(3L, "Leite", 3.99,10);
        System.out.println(cadastroProdutos.produtosSet);
        System.out.println(cadastroProdutos.exibirProdutosPorNome());
        System.out.println(cadastroProdutos.exibirProdutosPorPreco());
    }
    }

