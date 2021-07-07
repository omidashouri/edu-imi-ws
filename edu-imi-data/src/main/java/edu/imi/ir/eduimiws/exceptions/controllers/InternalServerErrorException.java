package edu.imi.ir.eduimiws.exceptions.controllers;

public class InternalServerErrorException extends RuntimeException {

    private static final long serialVersionUID = -2191734854416219718L;

    public InternalServerErrorException() {
        super();
    }

    public InternalServerErrorException(String message) {
        super(message);
    }

    public InternalServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
