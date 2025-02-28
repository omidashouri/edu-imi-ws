package edu.imi.ir.eduimiws.utilities.attendance;

import javax.persistence.AttributeConverter;

public class DayOfWeekConverter implements AttributeConverter<DayOfWeek, Long> {

    @Override
    public Long convertToDatabaseColumn(DayOfWeek attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public DayOfWeek convertToEntityAttribute(Long dbData) {
        if (dbData == null) {
            return null;
        }
        return DayOfWeek.getDayOfWeekByCode(dbData);
    }
}
