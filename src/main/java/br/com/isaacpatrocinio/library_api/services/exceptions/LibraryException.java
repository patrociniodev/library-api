package br.com.isaacpatrocinio.library_api.services.exceptions;

public class LibraryException extends RuntimeException {
    public LibraryException(String message) {
        super(message);
    }
}
