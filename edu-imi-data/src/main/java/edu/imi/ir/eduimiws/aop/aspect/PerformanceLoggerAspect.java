package edu.imi.ir.eduimiws.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;


@Aspect
@Component
@Slf4j
public class PerformanceLoggerAspect {

    @Around("@annotation(edu.imi.ir.eduimiws.aop.annotation.PerformanceLogger)")
    public Object logPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            long finishTime = System.currentTimeMillis();
            Duration duration = Duration.ofMillis(finishTime - startTime);
            log.info(String.format("Duration of %s execution was %s", proceedingJoinPoint.getSignature(), duration));
        }
    }
}
