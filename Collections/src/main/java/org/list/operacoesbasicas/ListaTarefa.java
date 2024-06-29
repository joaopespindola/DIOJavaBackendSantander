package org.list.operacoesbasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    private List<Tarefa> listaTarefa;

    public ListaTarefa() {
        this.listaTarefa = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        this.listaTarefa.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        List<Tarefa> tarefasParaRemover = new ArrayList<>();
        for (Tarefa tarefa : this.listaTarefa) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefasParaRemover.add(tarefa);
            }
        }
        listaTarefa.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTarefas() {
        return listaTarefa.size();
    }

    public void obterDescricoesTarefa() {
        System.out.println(listaTarefa);
    }

    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();

        listaTarefa.adicionarTarefa("Ir a academia");
        listaTarefa.adicionarTarefa("Faxina!");
        listaTarefa.adicionarTarefa("Faxina!");

        System.out.println(listaTarefa.obterNumeroTarefas());

        listaTarefa.removerTarefa("Faxina!");

        System.out.println(listaTarefa.obterNumeroTarefas());
        listaTarefa.obterDescricoesTarefa();
    }
}
