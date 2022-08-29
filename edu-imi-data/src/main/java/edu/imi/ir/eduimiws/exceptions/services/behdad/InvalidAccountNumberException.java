package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class InvalidAccountNumberException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidAccountNumberException() {
        super();
    }

    public InvalidAccountNumberException(String message) {
        super(message);
    }

    public InvalidAccountNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}