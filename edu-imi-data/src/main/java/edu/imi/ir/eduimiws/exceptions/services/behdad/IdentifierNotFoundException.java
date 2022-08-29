package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class IdentifierNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public IdentifierNotFoundException() {
        super();
    }

    public IdentifierNotFoundException(String message) {
        super(message);
    }

    public IdentifierNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}