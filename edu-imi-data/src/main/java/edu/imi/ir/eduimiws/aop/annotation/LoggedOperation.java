package edu.imi.ir.eduimiws.aop.annotation;

import edu.imi.ir.eduimiws.aop.enums.LoggedBusinessOperation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Opt-in idempotency + audit logging for POST command endpoints.
 * {@link #value()}'s {@link LoggedBusinessOperation#name()} must match a seeded
 * {@code crm.TBL_BUSINESS_OPERATION.OPERATION_NAME}.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggedOperation {

    LoggedBusinessOperation value();
}
