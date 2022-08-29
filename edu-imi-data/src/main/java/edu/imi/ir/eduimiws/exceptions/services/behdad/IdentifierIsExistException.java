package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class IdentifierIsExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public IdentifierIsExistException() {
        super();
    }

    public IdentifierIsExistException(String message) {
        super(message);
    }

    public IdentifierIsExistException(String message, Throwable cause) {
        super(message, cause);
    }
}