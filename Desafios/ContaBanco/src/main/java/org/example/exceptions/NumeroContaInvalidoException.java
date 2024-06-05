package org.example.exceptions;

public class NumeroContaInvalidoException extends RuntimeException {
    public NumeroContaInvalidoException(String mensagem) {
        super(mensagem);
    }
}