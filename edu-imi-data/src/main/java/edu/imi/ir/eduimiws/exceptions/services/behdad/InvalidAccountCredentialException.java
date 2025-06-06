package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class InvalidAccountCredentialException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidAccountCredentialException() {
        super();
    }

    public InvalidAccountCredentialException(String message) {
        super(message);
    }

    public InvalidAccountCredentialException(String message, Throwable cause) {
        super(message, cause);
    }
}