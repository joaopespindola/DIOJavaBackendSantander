package org.list.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
    private List<Pessoa> listaPessoas;

    public OrdenacaoPessoas() {
        this.listaPessoas = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        this.listaPessoas.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade(){
        List<Pessoa> pessoasPorIdade = new ArrayList<>(listaPessoas);
        Collections.sort(pessoasPorIdade);
        return pessoasPorIdade;
    }

    public List<Pessoa> ordenarPorAltura(){
        List<Pessoa> pessoasPorAltura = new ArrayList<>(listaPessoas);
        //QUando não passo o comparator, irá ficar subentendido que o
        //Comparable deve ser usado
        Collections.sort(pessoasPorAltura, new ComparatorPorAltura());
        return pessoasPorAltura;
    }

    public static void main(String[] args) {
        OrdenacaoPessoas ordenaPessoa = new OrdenacaoPessoas();

        ordenaPessoa.adicionarPessoa("Pedro", 25, 1.5);
        ordenaPessoa.adicionarPessoa("Joao", 32, 1.4);
        ordenaPessoa.adicionarPessoa("Jose", 30, 1.9);

        System.out.println(ordenaPessoa.ordenarPorAltura());
        System.out.println(ordenaPessoa.ordenarPorIdade());
    }
}
