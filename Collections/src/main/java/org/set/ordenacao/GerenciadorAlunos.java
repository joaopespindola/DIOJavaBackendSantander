package org.set.ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunosSet;

    public GerenciadorAlunos() {
        this.alunosSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media) {
        this.alunosSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(String nome) {
        this.alunosSet.removeIf(aluno -> aluno.getNome().equalsIgnoreCase(nome)); // Usando lambda
    }

    public Set<Aluno> exibirAlunosPorNome() {
        Set<Aluno> alunosPorNome = new TreeSet<>(alunosSet); // O TreeSet já faz a ordenação através do Comparable
        return alunosPorNome;
    }

    public Set<Aluno> exibirAlunosPorNota() {
        Set<Aluno> alunosPorNota = new TreeSet<>(new AlunoComparator());
        alunosPorNota.addAll(alunosSet);
        return alunosPorNota;
    }

    public void exibirAlunos() {
        for(Aluno aluno : alunosSet) {
            System.out.println(aluno);
        }
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adicionarAluno("Joao", 1L, 80.0);
        gerenciadorAlunos.adicionarAluno("Jose", 2L, 75.0);
        gerenciadorAlunos.adicionarAluno("Mateus", 3L, 60.0);
        gerenciadorAlunos.adicionarAluno("Joao Pedro", 1L, 90.0);
        gerenciadorAlunos.exibirAlunos();
        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());
        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());
        gerenciadorAlunos.removerAluno("Jose");
        gerenciadorAlunos.exibirAlunos();
    }
}
