package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class InvalidCredentialException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidCredentialException() {
        super();
    }

    public InvalidCredentialException(String message) {
        super(message);
    }

    public InvalidCredentialException(String message, Throwable cause) {
        super(message, cause);
    }
}