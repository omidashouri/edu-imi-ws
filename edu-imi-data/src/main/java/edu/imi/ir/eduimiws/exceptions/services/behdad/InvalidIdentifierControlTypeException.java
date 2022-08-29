package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class InvalidIdentifierControlTypeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidIdentifierControlTypeException() {
        super();
    }

    public InvalidIdentifierControlTypeException(String message) {
        super(message);
    }

    public InvalidIdentifierControlTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}