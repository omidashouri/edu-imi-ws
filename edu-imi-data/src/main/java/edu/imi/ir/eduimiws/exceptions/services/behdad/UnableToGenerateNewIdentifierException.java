package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class UnableToGenerateNewIdentifierException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnableToGenerateNewIdentifierException() {
        super();
    }

    public UnableToGenerateNewIdentifierException(String message) {
        super(message);
    }

    public UnableToGenerateNewIdentifierException(String message, Throwable cause) {
        super(message, cause);
    }
}