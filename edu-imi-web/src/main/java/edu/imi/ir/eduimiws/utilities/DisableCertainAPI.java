package edu.imi.ir.eduimiws.utilities;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Aspect
@RequiredArgsConstructor
@Component
public class DisableCertainAPI {


    private final HttpServletResponse httpServletResponse;

    @Pointcut(" @annotation(disableMethod)")
    protected void disabledMethods(DisableMethod disableMethod) {
        // disabled methods pointcut
    }

    @Around("disabledMethods(disableMethod)")
    public void dontRun(JoinPoint jp, DisableMethod disableMethod) throws IOException {
        httpServletResponse.sendError(HttpStatus.NOT_FOUND.value(), "Not found");
    }
}
