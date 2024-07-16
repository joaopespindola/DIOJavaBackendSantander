package br.com.bootcamp.dominio;

import br.com.bootcamp.exceptions.AlreadyEnrolledException;
import br.com.bootcamp.exceptions.NoContentAvailableException;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
public class Programador {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();// Estrutura escolhida foi o Set pois não permite elemento duplicado
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        if (bootcamp.getProgramadoresInscritos().contains(this)) {
            throw new AlreadyEnrolledException("Programador já inscrito no bootcamp.");
        }
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getProgramadoresInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            throw new NoContentAvailableException("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public Double calcularTotalXp() {
        return this.conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Programador that = (Programador) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
