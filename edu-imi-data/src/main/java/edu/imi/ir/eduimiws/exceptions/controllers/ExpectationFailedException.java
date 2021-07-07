package edu.imi.ir.eduimiws.exceptions.controllers;

public class ExpectationFailedException extends RuntimeException {

    private static final long serialVersionUID = -2191734854416219718L;

    public ExpectationFailedException() {
        super();
    }

    public ExpectationFailedException(String message) {
        super(message);
    }

    public ExpectationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
