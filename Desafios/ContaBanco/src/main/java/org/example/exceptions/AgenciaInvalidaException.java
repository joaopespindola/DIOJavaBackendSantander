package org.example.exceptions;

public class AgenciaInvalidaException extends RuntimeException {
    public AgenciaInvalidaException(String mensagem) {
        super(mensagem);
    }
}
