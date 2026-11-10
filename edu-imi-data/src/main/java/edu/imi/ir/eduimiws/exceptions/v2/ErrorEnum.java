package edu.imi.ir.eduimiws.exceptions.v2;

import lombok.Getter;

@Getter
public enum ErrorEnum {

    RECORD_NOT_FOUND("record.not.found", "IMI00002"),
    BAD_REQUEST("bad.request", "IMI00400"),
    REQUEST_BODY_REQUIRED("request.body.required", "IMI00057"),
    REQUEST_BODY_INVALID("request.body.invalid", "IMI00075"),
    REQUEST_ID_INVALID("request.id.invalid", "IMI00071"),
    REQUEST_ID_DUPLICATE_SUCCESS("request.id.duplicate.success", "IMI00070"),
    INTERNAL_REQUEST_RESPONSE_NOT_FOUND("internal.request.response.not.found", "IMI00073"),
    UNEXPECTED_ERROR("unexpected.error", "IMI00072"),
    NOT_FOUND("not.found", "IMI00404"),
    CONFLICT("conflict", "IMI00409"),
    NOT_ACCEPTABLE("not.acceptable", "IMI00406"),
    EXPECTATION_FAILED("expectation.failed", "IMI00417"),
    INTERNAL_SERVER_ERROR("internal.server.error", "IMI00500");

    private final String key;
    private final String code;

    ErrorEnum(String key, String code) {
        this.key = key;
        this.code = code;
    }
}
