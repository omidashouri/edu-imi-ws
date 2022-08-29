package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class UnableToGetTransactionsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnableToGetTransactionsException() {
        super();
    }

    public UnableToGetTransactionsException(String message) {
        super(message);
    }

    public UnableToGetTransactionsException(String message, Throwable cause) {
        super(message, cause);
    }
}