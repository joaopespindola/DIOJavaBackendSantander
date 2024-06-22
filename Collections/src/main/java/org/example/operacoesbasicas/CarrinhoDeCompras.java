package org.example.operacoesbasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> carrinhoCompras;

    public CarrinhoDeCompras() {
        this.carrinhoCompras = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        carrinhoCompras.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        for (Item item : carrinhoCompras) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                itensParaRemover.add(item);
            }
        }
        carrinhoCompras.removeAll(itensParaRemover);
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Item item : carrinhoCompras) {
            valorTotal += item.getPreco() * item.getQuantidade();
        }
        return valorTotal;
    }

    public void exibirItens(){
        for (Item item : carrinhoCompras) {
            System.out.println(item.toString());
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoCompras = new CarrinhoDeCompras();

        carrinhoCompras.adicionarItem("TV 32'", 1250,2);
        carrinhoCompras.adicionarItem("TV 32'", 2000,2);
        carrinhoCompras.adicionarItem("TV 55'", 1250,2);
        System.out.println("Valor total: " + carrinhoCompras.calcularValorTotal());
        carrinhoCompras.removerItem("TV 32'");
        carrinhoCompras.exibirItens();
    }
}
