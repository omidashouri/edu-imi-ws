package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class TransactionDoesNotBelongToAccount extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TransactionDoesNotBelongToAccount() {
        super();
    }

    public TransactionDoesNotBelongToAccount(String message) {
        super(message);
    }

    public TransactionDoesNotBelongToAccount(String message, Throwable cause) {
        super(message, cause);
    }
}