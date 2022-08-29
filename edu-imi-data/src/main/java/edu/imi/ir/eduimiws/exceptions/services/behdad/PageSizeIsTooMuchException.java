package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class PageSizeIsTooMuchException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PageSizeIsTooMuchException() {
        super();
    }

    public PageSizeIsTooMuchException(String message) {
        super(message);
    }

    public PageSizeIsTooMuchException(String message, Throwable cause) {
        super(message, cause);
    }
}