package edu.imi.ir.eduimiws.exceptions.controllers;

public class DateParseException extends RuntimeException {

    private static final long serialVersionUID = -2191734854416219718L;

    public DateParseException() {
        super();
    }

    public DateParseException(String message) {
        super(message);
    }

    public DateParseException(String message, Throwable cause) {
        super(message, cause);
    }
}