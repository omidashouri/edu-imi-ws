package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class InvalidTransactionTypeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidTransactionTypeException() {
        super();
    }

    public InvalidTransactionTypeException(String message) {
        super(message);
    }

    public InvalidTransactionTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}