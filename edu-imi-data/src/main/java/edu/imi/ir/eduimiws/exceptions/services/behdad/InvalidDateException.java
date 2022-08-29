package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class InvalidDateException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidDateException() {
        super();
    }

    public InvalidDateException(String message) {
        super(message);
    }

    public InvalidDateException(String message, Throwable cause) {
        super(message, cause);
    }
}