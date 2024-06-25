package org.list.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> ListaNumeros;

    public OrdenacaoNumeros(){
        this.ListaNumeros = new ArrayList<Integer>();
    }

    public void adicionarNumero(int numero){
        this.ListaNumeros.add(numero);
    }

    public List<Integer> ordenarDescendente() {
        List<Integer> numerosDescendentes = new ArrayList<>(this.ListaNumeros);
        numerosDescendentes.sort(Collections.reverseOrder());
        //Collections.sort(numerosDescendentes.reversed());
        return numerosDescendentes;
    }

    public List<Integer> ordenarAscendente() {
        List<Integer> numerosAscendentes = new ArrayList<>(this.ListaNumeros);
        Collections.sort(numerosAscendentes);
        return numerosAscendentes;
    }

    public void exibirNumeros() {
        System.out.println(this.ListaNumeros);
    }

    public static void main(String[] args) {
        OrdenacaoNumeros numeros = new OrdenacaoNumeros();

        numeros.adicionarNumero(12);
        numeros.adicionarNumero(50);
        numeros.adicionarNumero(2);
        numeros.adicionarNumero(21);

        System.out.println(numeros.ordenarAscendente());
        numeros.exibirNumeros();
        System.out.println(numeros.ordenarDescendente());
        numeros.exibirNumeros();
    }
}
