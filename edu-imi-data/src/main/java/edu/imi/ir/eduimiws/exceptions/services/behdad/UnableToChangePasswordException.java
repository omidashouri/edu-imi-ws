package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class UnableToChangePasswordException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnableToChangePasswordException() {
        super();
    }

    public UnableToChangePasswordException(String message) {
        super(message);
    }

    public UnableToChangePasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}