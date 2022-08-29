package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class PasswordIsNotStrongException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PasswordIsNotStrongException() {
        super();
    }

    public PasswordIsNotStrongException(String message) {
        super(message);
    }

    public PasswordIsNotStrongException(String message, Throwable cause) {
        super(message, cause);
    }
}