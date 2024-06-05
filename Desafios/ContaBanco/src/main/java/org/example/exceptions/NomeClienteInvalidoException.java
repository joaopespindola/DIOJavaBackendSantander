package org.example.exceptions;

public class NomeClienteInvalidoException extends RuntimeException {
    public NomeClienteInvalidoException(String mensagem) {
        super(mensagem);
    }
}
