package br.com.bootcamp.exceptions;

public class NoContentAvailableException extends RuntimeException {
    public NoContentAvailableException(String message) {
        super(message);
    }
}