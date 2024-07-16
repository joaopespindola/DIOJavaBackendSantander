package br.com.bootcamp.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@SuperBuilder
public class Mentoria extends Conteudo{
    private LocalDate data;

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20;
    }
}
