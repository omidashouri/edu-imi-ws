package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class InvalidPageNumberException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidPageNumberException() {
        super();
    }

    public InvalidPageNumberException(String message) {
        super(message);
    }

    public InvalidPageNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}