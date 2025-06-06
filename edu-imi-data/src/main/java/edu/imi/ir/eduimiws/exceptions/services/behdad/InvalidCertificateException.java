package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class InvalidCertificateException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidCertificateException() {
        super();
    }

    public InvalidCertificateException(String message) {
        super(message);
    }

    public InvalidCertificateException(String message, Throwable cause) {
        super(message, cause);
    }
}