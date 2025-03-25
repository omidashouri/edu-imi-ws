package edu.imi.ir.eduimiws.validators;


import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class JalaliDateValidator implements ConstraintValidator<JalaliDateValidation, String> {

    private String inValidValues;
    private static final String DATE_PATTERN = "^\\d{4}/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$";

    @Override
    public void initialize(JalaliDateValidation constraintAnnotation) {
        // Optional: Initialize any resources or configurations here
        log.info("Initialize AgeValidator");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(value);

        if (value == null || !matcher.matches()) {
            return false;
        }
        return true;
    }
}
