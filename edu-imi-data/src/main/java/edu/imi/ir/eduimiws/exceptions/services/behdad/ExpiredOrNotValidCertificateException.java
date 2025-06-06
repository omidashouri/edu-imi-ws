package edu.imi.ir.eduimiws.exceptions.services.behdad;

public class ExpiredOrNotValidCertificateException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExpiredOrNotValidCertificateException() {
        super();
    }

    public ExpiredOrNotValidCertificateException(String message) {
        super(message);
    }

    public ExpiredOrNotValidCertificateException(String message, Throwable cause) {
        super(message, cause);
    }
}