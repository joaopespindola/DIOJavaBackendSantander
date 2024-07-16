package br.com.bootcamp.dominio;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private Set<Programador> programadoresInscritos = new HashSet<>();
    private Set<Conteudo> conteudos;

    public Bootcamp(String nome, String descricao, LinkedHashSet<Conteudo> conteudos) {
        this.nome = nome;
        this.descricao = descricao;
        this.conteudos = conteudos;
    }
}
