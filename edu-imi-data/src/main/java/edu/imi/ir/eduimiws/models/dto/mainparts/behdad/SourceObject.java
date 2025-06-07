package edu.imi.ir.eduimiws.models.dto.mainparts.behdad;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class SourceObject {
    private Map<String, Object> fields = new HashMap<String, Object>();

    public void addObject(Object source) {
        Field[] fields = source.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                this.fields.put(field.getName(),field.get(source));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
