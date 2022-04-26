package edu.imi.ir.eduimiws.exceptions.controllers;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;

public class ExpiredJwtTokenException extends ExpiredJwtException {


    public ExpiredJwtTokenException(Header header, Claims claims, String message) {
        super(header, claims, message);
    }

    public ExpiredJwtTokenException(Header header, Claims claims, String message, Throwable cause) {
        super(header, claims, message, cause);
    }
}
