package edu.imi.ir.eduimiws.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = JalaliDateValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JalaliDateValidation {
    String message() default "Jalali Date Format is Incorrect, the correct format is YYYY/MM/DD";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
