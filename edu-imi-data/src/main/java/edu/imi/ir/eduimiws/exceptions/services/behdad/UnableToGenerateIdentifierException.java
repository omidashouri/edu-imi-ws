package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class UnableToGenerateIdentifierException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnableToGenerateIdentifierException() {
        super();
    }

    public UnableToGenerateIdentifierException(String message) {
        super(message);
    }

    public UnableToGenerateIdentifierException(String message, Throwable cause) {
        super(message, cause);
    }
}