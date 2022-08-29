package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class InvalidPageSizeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidPageSizeException() {
        super();
    }

    public InvalidPageSizeException(String message) {
        super(message);
    }

    public InvalidPageSizeException(String message, Throwable cause) {
        super(message, cause);
    }
}