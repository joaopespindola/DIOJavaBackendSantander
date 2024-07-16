package br.com.bootcamp.exceptions;

public class BootcampNotFoundException extends RuntimeException {
    public BootcampNotFoundException(String message) {
        super(message);
    }
}