package edu.imi.ir.eduimiws.aop.aspect.crm;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ServicesAspect {

    @Pointcut("within(edu.imi.ir.eduimiws.services..*)")
    public void serviceOrSamePackageRepository() {
        log.info("Aspect Services - PintCut");
    }

    @Before("serviceOrSamePackageRepository()")
    public void before(JoinPoint joinPoint) {
        log.info("Before: " + joinPoint.getSignature());
    }

    @After("serviceOrSamePackageRepository()")
    public void after(JoinPoint joinPoint) {
        log.info("After: " + joinPoint.getSignature());
    }

    @AfterThrowing(value = "serviceOrSamePackageRepository()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        log.info("AfterThrowing: " + joinPoint.getSignature() + "- return Value: " + exception.getMessage());
    }


    @AfterReturning(value = "serviceOrSamePackageRepository()", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue) {
        log.info("AfterReturning: " + joinPoint.getSignature() + "- return Value: " + returnValue);
    }

    @Around(value = "serviceOrSamePackageRepository()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("Around: " + proceedingJoinPoint.getSignature());
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            log.info("Around: " + proceedingJoinPoint.getSignature());
        }
    }
}
