package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class InvalidIdentifierException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidIdentifierException() {
        super();
    }

    public InvalidIdentifierException(String message) {
        super(message);
    }

    public InvalidIdentifierException(String message, Throwable cause) {
        super(message, cause);
    }
}