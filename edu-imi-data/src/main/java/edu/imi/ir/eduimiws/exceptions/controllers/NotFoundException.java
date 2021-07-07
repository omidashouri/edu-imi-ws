package edu.imi.ir.eduimiws.exceptions.controllers;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -2191734854416219718L;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}