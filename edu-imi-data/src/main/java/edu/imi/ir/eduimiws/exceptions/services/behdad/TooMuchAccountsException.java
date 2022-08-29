package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class TooMuchAccountsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TooMuchAccountsException() {
        super();
    }

    public TooMuchAccountsException(String message) {
        super(message);
    }

    public TooMuchAccountsException(String message, Throwable cause) {
        super(message, cause);
    }
}