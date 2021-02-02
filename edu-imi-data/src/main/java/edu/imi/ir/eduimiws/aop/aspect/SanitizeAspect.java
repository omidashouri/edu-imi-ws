package edu.imi.ir.eduimiws.aop.aspect;


import edu.imi.ir.eduimiws.aop.annotation.Sanitize;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.util.Arrays;

//@Component
//@Aspect
@Slf4j
public class SanitizeAspect {
    @Around("execution(* edu..services..*.*(*,..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        return proceedingJoinPoint
                .proceed(sanitizeArgumentsIfRequired(proceedingJoinPoint.getArgs(), methodSignature));
    }


    private Object[] sanitizeArgumentsIfRequired(Object[] args, MethodSignature methodSignature) {
        Object[] filteredArgs = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            filteredArgs[i] = sanitizeArgumentIfRequired(args[i],
                    methodSignature.getMethod().getParameterAnnotations()[i]);
        }
        return filteredArgs;

    }

    private Object sanitizeArgumentIfRequired(Object arg, Annotation[] parameterAnnotations) {
        if (containsAnnotationOfType(parameterAnnotations, Sanitize.class) && arg.getClass() == String.class)
            return "***sanitized***";
        else
            return arg;
    }

    private boolean containsAnnotationOfType(Annotation[] parameterAnnotations, Class sanitizedClass) {
        return Arrays.stream(parameterAnnotations)
                .map(Annotation::annotationType)
                .anyMatch(sanitizedClass::equals);
    }

}
