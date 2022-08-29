package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class IdentifierIsNotEffectiveException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public IdentifierIsNotEffectiveException() {
        super();
    }

    public IdentifierIsNotEffectiveException(String message) {
        super(message);
    }

    public IdentifierIsNotEffectiveException(String message, Throwable cause) {
        super(message, cause);
    }
}