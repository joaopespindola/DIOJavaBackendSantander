package br.com.bootcamp.exceptions;

public class AlreadyEnrolledException extends RuntimeException {
    public AlreadyEnrolledException(String message) {
        super(message);
    }
}
