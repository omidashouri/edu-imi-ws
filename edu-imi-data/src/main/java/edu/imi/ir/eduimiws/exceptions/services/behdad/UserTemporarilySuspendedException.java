package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class UserTemporarilySuspendedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserTemporarilySuspendedException() {
        super();
    }

    public UserTemporarilySuspendedException(String message) {
        super(message);
    }

    public UserTemporarilySuspendedException(String message, Throwable cause) {
        super(message, cause);
    }
}