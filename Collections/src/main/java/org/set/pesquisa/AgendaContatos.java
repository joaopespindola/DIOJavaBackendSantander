package org.set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        this.contatoSet.add(new Contato(numero, nome));
    }

    public void exibirContatos() {
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();
        for (Contato contato : this.contatoSet) {
            if (contato.getNome().startsWith(nome)) {
                contatosPorNome.add(contato);
            }
        }
        return contatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero){
        Contato contatoAtualizado = null;
        for (Contato contato : this.contatoSet) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contato.setNumero(novoNumero);
                contatoAtualizado = contato;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Jose", 999487536);
        agendaContatos.adicionarContato("Maria", 997845217);
        agendaContatos.adicionarContato("Joao", 998754479);
        agendaContatos.adicionarContato("Jose Maria", 999487556);
        agendaContatos.adicionarContato("Renato", 999487536);

        agendaContatos.exibirContatos();
        System.out.println(agendaContatos.atualizarNumeroContato("Jose", 999487534));
        agendaContatos.exibirContatos();
        System.out.println(agendaContatos.pesquisarPorNome("Jose"));

    }
}
