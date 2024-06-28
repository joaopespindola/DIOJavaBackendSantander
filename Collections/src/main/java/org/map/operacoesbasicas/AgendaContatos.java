package org.map.operacoesbasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> contatosMap;

    public AgendaContatos() {
        contatosMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        contatosMap.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if(!contatosMap.isEmpty()) {
            contatosMap.remove(nome);
        }
    }

    public void exibirContato() {
        System.out.println(contatosMap);
    }

    public Integer pesquisarPorNome(String nome) {
        Integer numeroPorNome = null;
        if(!contatosMap.isEmpty()) {
            numeroPorNome = contatosMap.get(nome);
            if(numeroPorNome == null) {
                System.out.println("Nome nao encontrado na agenda");
        }
        } else System.out.println("A agenda está vazia");
        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Joao", 99765276);
        agendaContatos.adicionarContato("Maria", 998742474);
        agendaContatos.adicionarContato("Jose", 999472157);
        agendaContatos.adicionarContato("Jose", 978454741); // Map não permite chave duplicada
        agendaContatos.exibirContato();

        System.out.println("O valor da chave é: " + agendaContatos.pesquisarPorNome("Joao"));

        agendaContatos.removerContato("Jose");
        agendaContatos.exibirContato();
    }
}
