package edu.imi.ir.eduimiws.utilities;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.function.Function;

@Component
public class ConvertorUtil {

    public <T> T makeEmptyValueNull(T object) {

        for (Field field : object.getClass().getDeclaredFields()) {
            try {
                if (field.getType().isAssignableFrom(String.class)) {
                    String readValue = (String) FieldUtils.readDeclaredField(object, field.getName(), true);
                    if (readValue != null && readValue.isEmpty()) {
                        FieldUtils.writeDeclaredField(object, field.getName(), null, true);
                    }
                }
            } catch (IllegalAccessException e) {
                System.out.println("later correct it");
            }
        }
        return object;
    }

    public <T> T makeCharacterSetPerson(T object) {

        for (Field field : object.getClass().getDeclaredFields()) {
            try {
                if (field.getType().isAssignableFrom(String.class)) {
                    String readValue = (String) FieldUtils.readDeclaredField(object, field.getName(), true);
                    if (readValue != null) {
                        String persianChar = readValue
                                .replaceAll("\u064A", "\u06CC")      //Y
                                .replaceAll("\u0643", "\u06A9");     //K
                        FieldUtils.writeDeclaredField(object, field.getName(), persianChar, true);
                    }
                }
            } catch (IllegalAccessException e) {
                System.out.println("later correct it");
            }
        }
        return object;
    }

    public Function<String, String> characterEncodingStringRequest = (String inputString) -> {
        String encodedString = null;
        if (inputString != null) {
            encodedString = inputString
                    .replaceAll("\u06CC", "\u064A")     //Y
                    .replaceAll("\u06A9", "\u0643");    //K
        }
        return encodedString;
    };
}
