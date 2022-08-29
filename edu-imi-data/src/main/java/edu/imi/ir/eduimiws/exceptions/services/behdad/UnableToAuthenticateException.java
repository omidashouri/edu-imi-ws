package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class UnableToAuthenticateException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnableToAuthenticateException() {
        super();
    }

    public UnableToAuthenticateException(String message) {
        super(message);
    }

    public UnableToAuthenticateException(String message, Throwable cause) {
        super(message, cause);
    }
}