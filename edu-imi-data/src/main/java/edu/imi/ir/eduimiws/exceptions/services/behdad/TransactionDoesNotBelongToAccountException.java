package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class TransactionDoesNotBelongToAccountException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TransactionDoesNotBelongToAccountException() {
        super();
    }

    public TransactionDoesNotBelongToAccountException(String message) {
        super(message);
    }

    public TransactionDoesNotBelongToAccountException(String message, Throwable cause) {
        super(message, cause);
    }
}