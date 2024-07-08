package org.banco.exceptions;

public class ValorInvalidoException extends IllegalArgumentException {
    public ValorInvalidoException(String message) {
        super(message);
    }
}
