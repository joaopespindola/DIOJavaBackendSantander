package pesquisa;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> livros;

    public CatalogoLivros() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoDePublicacao) {
        livros.add(new Livro(titulo, autor, anoDePublicacao));
    }

    public List<Livro> pesquisarLivrosPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        if(!livros.isEmpty()) {
            for (Livro livro : livros) {
                if(livro.getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.add(livro);
                }
            }
        } else{
            System.out.println("Lista de livros está vazia.");
        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisarLivrosPorIntervaloDeAnos(int anoInicial, int anoFinal) {
        List<Livro> livrosPorAno = new ArrayList<>();
        if(!livros.isEmpty()) {
            for (Livro livro : livros) {
                if(livro.getAnoDePublicacao() >= anoInicial && livro.getAnoDePublicacao() <= anoFinal) {
                    livrosPorAno.add(livro);
                }
            }
        }
        return livrosPorAno;
    }

    public Livro pesquisarLivroPorTitulo(String titulo) {
        Livro livroPorTitulo = null;
        if(!livros.isEmpty()) {
            for (Livro livro : livros) {
                if(livro.getTitulo().equalsIgnoreCase(titulo)) {
                    livroPorTitulo = livro;
                    break; // break pois o exercício pede só um livro
                }
            }
        }
        return livroPorTitulo;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivro("Harry Potter 1", "JK Rowling", 2003);
        catalogoLivros.adicionarLivro("Harry Potter 2", "JK Rowling", 2004);
        catalogoLivros.adicionarLivro("Harry Potter 3", "JK Rowling", 2005);
        catalogoLivros.adicionarLivro("Harry Potter 1", "JK Rowling Stones", 2003);

        System.out.println(catalogoLivros.pesquisarLivrosPorAutor("JK Rowling"));
        System.out.println(catalogoLivros.pesquisarLivrosPorIntervaloDeAnos(2003, 2005));
        System.out.println(catalogoLivros.pesquisarLivroPorTitulo("Harry Potter 1"));
    }
}
