package edu.imi.ir.eduimiws.utilities.attendance;

import javax.persistence.AttributeConverter;

public class IoSourceTypeConverter implements AttributeConverter<IoSourceType, Long> {

    @Override
    public Long convertToDatabaseColumn(IoSourceType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public IoSourceType convertToEntityAttribute(Long dbData) {
        if (dbData == null) {
            return null;
        }
        return IoSourceType.getIoSourceTypeByCode(dbData);
    }
}
