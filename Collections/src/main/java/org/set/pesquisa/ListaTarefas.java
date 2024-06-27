package org.set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefasSet;

    public ListaTarefas() {
        this.tarefasSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefasSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        for(Tarefa tarefa : tarefasSet) {
            if(tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefasSet.remove(tarefa);
                break;
            }
        }
    }

    public void exibirTarefas() {
        for(Tarefa tarefa : tarefasSet) {
            System.out.println(tarefa);
        }
    }

    public void contarTarefas() {
        System.out.println(tarefasSet.size());
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for(Tarefa tarefa : tarefasSet) {
            if(tarefa.isConcluida()){
                tarefasConcluidas.add(tarefa);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        for(Tarefa tarefa : tarefasSet) {
            if(!tarefa.isConcluida()){
                tarefasPendentes.add(tarefa);
            }
        }
        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao) {
        for (Tarefa tarefa : tarefasSet) {
            if(tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefa.setConcluida(true);
                break;
            }
        }
    }

    public void marcarTarefaPendente(String descricao) {
        for (Tarefa tarefa : tarefasSet) {
            if(tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefa.setConcluida(false);
                break;
            }
        }
    }

    public void limparListaTarefas() {
        tarefasSet.clear();
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();
        listaTarefas.adicionarTarefa("Fazer compras");
        listaTarefas.adicionarTarefa("Trabalhar");
        listaTarefas.adicionarTarefa("Ir a academia");
        listaTarefas.adicionarTarefa("Ir a academia");

        listaTarefas.contarTarefas();
        listaTarefas.exibirTarefas();
        listaTarefas.marcarTarefaConcluida("Ir a academia");
        System.out.println(listaTarefas.obterTarefasConcluidas());
        System.out.println(listaTarefas.obterTarefasPendentes());
        listaTarefas.marcarTarefaPendente("Ir a academia");
        listaTarefas.exibirTarefas();
        listaTarefas.removerTarefa("Fazer compras");
        listaTarefas.exibirTarefas();
        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();
    }
}
