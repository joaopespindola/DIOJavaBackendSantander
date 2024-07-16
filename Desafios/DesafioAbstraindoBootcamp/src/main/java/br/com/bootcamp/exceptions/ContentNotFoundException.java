package br.com.bootcamp.exceptions;

public class ContentNotFoundException extends RuntimeException {
    public ContentNotFoundException(String message) {
        super(message);
    }
}
