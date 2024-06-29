package org.map.ordenacao;

import java.util.*;

public class LivrariaOnline {
    Map<String, Livro> livrosMap;

    public LivrariaOnline() {
        livrosMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco) {
        livrosMap.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo) {
        List<String> keysParaRemover = new ArrayList<>();
        if (livrosMap.isEmpty()) {
            System.out.println("A livraria esta vazia!");
        }

        for (Map.Entry<String, Livro> livro : livrosMap.entrySet()) {
            if (livro.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                keysParaRemover.add(livro.getKey());
            }
        }
        if (keysParaRemover.isEmpty()) {
            System.out.println("Livro nao encontrado");
        } else {
            for (String key : keysParaRemover) {
                livrosMap.remove(key);
            }
        }
    }

    public List<Livro> pesquisarLivrosPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        if (livrosMap.isEmpty()) {
            System.out.println("A livraria esta vazia!");
        }
        for (Map.Entry<String, Livro> livro : livrosMap.entrySet()) {
            if (livro.getValue().getAutor().equalsIgnoreCase(autor)) {
                livrosPorAutor.add(livro.getValue());
            }
        }
        return livrosPorAutor;
    }

    public void exibirLivrosOrdenadosPorPreco() {
        if (livrosMap.isEmpty()) {
            System.out.println("A livraria esta vazia!");
        }
        List<Livro> livrosPorPreco = new ArrayList<>(livrosMap.values());
        Collections.sort(livrosPorPreco, new comparatorPorPreco());
        System.out.println(livrosPorPreco);
    }

    public List<Livro> obterLivroMaisCaro() {
        List<Livro> livrosMaisCaros = new ArrayList<>();
        double livroMaisCaro = Double.MIN_VALUE;
        if (livrosMap.isEmpty()) {
            System.out.println("A livraria esta vazia!");
        }
        for (Livro livro : livrosMap.values()) {
            if (livro.getPreco() > livroMaisCaro) {
                livroMaisCaro = livro.getPreco();
            }
        }
        for (Map.Entry<String, Livro> livro : livrosMap.entrySet()) {
            if (livro.getValue().getPreco() == livroMaisCaro) {
                livrosMaisCaros.add(livro.getValue());
            }
        }
        return livrosMaisCaros;
    }

    public List<Livro> exibirLivroMaisBarato() {
        List<Livro> livrosMaisBaratos = new ArrayList<>();
        double livroMaisBarato = Double.MAX_VALUE;
        if (livrosMap.isEmpty()) {
            System.out.println("A livraria esta vazia!");
        }
        for (Livro livro : livrosMap.values()) {
            if (livro.getPreco() < livroMaisBarato) {
                livroMaisBarato = livro.getPreco();
            }
        }
        for (Map.Entry<String, Livro> livro : livrosMap.entrySet()) {
            if (livro.getValue().getPreco() == livroMaisBarato) {
                livrosMaisBaratos.add(livro.getValue());
            }
        }
        return livrosMaisBaratos;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();


        livrariaOnline.adicionarLivro("link6", "Machine Learning", "Author F", 119.99);
        livrariaOnline.adicionarLivro("link7", "Operating Systems", "Author G", 89.99);
        livrariaOnline.adicionarLivro("link1", "Java Programming", "Author J", 119.99);
        livrariaOnline.adicionarLivro("link2", "Python Programming", "Author B", 29.99);
        livrariaOnline.adicionarLivro("link9", "Operating Systems", "Author J", 119.99);
        livrariaOnline.adicionarLivro("link3", "C++ Programming", "Author C", 49.99);
        livrariaOnline.adicionarLivro("link5", "Artificial Intelligence", "Author E", 69.99);
        livrariaOnline.adicionarLivro("link8", "Web Development with JavaScript", "Author H", 99.99);
        livrariaOnline.adicionarLivro("link10", "Computer Networks", "Author J", 119.99);

        livrariaOnline.exibirLivrosOrdenadosPorPreco();
        livrariaOnline.removerLivro("Operating Systems");
        livrariaOnline.exibirLivrosOrdenadosPorPreco();
        System.out.println("Livros do autor 'Author J': " + livrariaOnline.pesquisarLivrosPorAutor("Author J"));
        System.out.println("Livro(s) mais caro(s): " + livrariaOnline.obterLivroMaisCaro());
        System.out.println("Livro(s) mais barato(s): " + livrariaOnline.exibirLivroMaisBarato());
    }
}
