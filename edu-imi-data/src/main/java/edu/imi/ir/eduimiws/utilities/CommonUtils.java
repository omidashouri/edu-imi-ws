package edu.imi.ir.eduimiws.utilities;

import edu.imi.ir.eduimiws.exceptions.controllers.NotAcceptableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Component
@Slf4j
public class CommonUtils {

    Predicate<String> isInputEqualValue(String value) {
        Predicate<String> stringPredicate = input -> input.equalsIgnoreCase(value);
        return stringPredicate;
    }

    public void nullInstanceFieldsForValues(Object instance, List values) {
        Field[] classFields = instance.getClass().getDeclaredFields();
        values.forEach(value->{
            Stream.of(classFields)
                    .peek(fld -> fld.setAccessible(true))
                    .filter(fld -> {
                        boolean fldCheck = false;
                        try {
                            if (Objects.nonNull(fld.get(instance)))
                                fldCheck = fld.get(instance).equals(value);
                        } catch (IllegalAccessException e) {
                            throw new NotAcceptableException(e.getMessage());
                        }
                        return fldCheck;
                    }).forEach(fld -> {
                try {
                    fld.set(instance, null);
                } catch (IllegalAccessException e) {
                    throw new NotAcceptableException(e.getMessage());
                }
            });
        });
    }
}
