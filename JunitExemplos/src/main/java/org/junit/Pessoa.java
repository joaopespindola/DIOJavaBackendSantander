package org.junit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
@Getter
@Setter
public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;

    public int getIdade() {
        return (int) ChronoUnit.YEARS.between(dataNascimento, LocalDateTime.now());
    }

    public boolean ehMaiorDeIdade() {
        return this.getIdade() >= 18;
    }
}
