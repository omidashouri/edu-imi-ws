package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class InvalidIdentifierCodeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidIdentifierCodeException() {
        super();
    }

    public InvalidIdentifierCodeException(String message) {
        super(message);
    }

    public InvalidIdentifierCodeException(String message, Throwable cause) {
        super(message, cause);
    }
}