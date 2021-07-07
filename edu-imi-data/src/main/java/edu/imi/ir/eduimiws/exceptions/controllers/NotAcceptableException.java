package edu.imi.ir.eduimiws.exceptions.controllers;

public class NotAcceptableException extends RuntimeException {

    private static final long serialVersionUID = -2191734854416219718L;

    public NotAcceptableException() {
        super();
    }

    public NotAcceptableException(String message) {
        super(message);
    }

    public NotAcceptableException(String message, Throwable cause) {
        super(message, cause);
    }
}