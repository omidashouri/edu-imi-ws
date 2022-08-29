package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class InvalidIdentifierTypeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidIdentifierTypeException() {
        super();
    }

    public InvalidIdentifierTypeException(String message) {
        super(message);
    }

    public InvalidIdentifierTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}