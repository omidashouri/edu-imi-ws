package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class PasswordShouldBeChangeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PasswordShouldBeChangeException() {
        super();
    }

    public PasswordShouldBeChangeException(String message) {
        super(message);
    }

    public PasswordShouldBeChangeException(String message, Throwable cause) {
        super(message, cause);
    }
}