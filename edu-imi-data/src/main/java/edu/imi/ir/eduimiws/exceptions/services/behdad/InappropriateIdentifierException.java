package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class InappropriateIdentifierException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InappropriateIdentifierException() {
        super();
    }

    public InappropriateIdentifierException(String message) {
        super(message);
    }

    public InappropriateIdentifierException(String message, Throwable cause) {
        super(message, cause);
    }
}