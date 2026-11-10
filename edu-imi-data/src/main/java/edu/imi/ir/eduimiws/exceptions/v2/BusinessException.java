package edu.imi.ir.eduimiws.exceptions.v2;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException {

    private final ErrorEnum errorEnum;
    private final Map<String, List<String>> detail;
    private final Object[] messageParams;

    public BusinessException(ErrorEnum errorEnum) {
        this(null, errorEnum, null, (Object[]) null);
    }

    public BusinessException(Throwable cause, ErrorEnum errorEnum, Map<String, List<String>> detail,
                             Object... messageParams) {
        super(errorEnum.getKey(), cause);
        this.errorEnum = errorEnum;
        this.detail = detail;
        this.messageParams = messageParams;
    }
}
