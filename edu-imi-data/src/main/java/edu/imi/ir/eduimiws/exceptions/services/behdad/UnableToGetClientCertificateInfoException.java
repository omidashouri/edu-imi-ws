package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class UnableToGetClientCertificateInfoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnableToGetClientCertificateInfoException() {
        super();
    }

    public UnableToGetClientCertificateInfoException(String message) {
        super(message);
    }

    public UnableToGetClientCertificateInfoException(String message, Throwable cause) {
        super(message, cause);
    }
}