package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class VerhoeffException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public VerhoeffException() {
        super();
    }

    public VerhoeffException(String message) {
        super(message);
    }

    public VerhoeffException(String message, Throwable cause) {
        super(message, cause);
    }
}