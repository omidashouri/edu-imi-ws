package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class InvalidAmountException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidAmountException() {
        super();
    }

    public InvalidAmountException(String message) {
        super(message);
    }

    public InvalidAmountException(String message, Throwable cause) {
        super(message, cause);
    }
}