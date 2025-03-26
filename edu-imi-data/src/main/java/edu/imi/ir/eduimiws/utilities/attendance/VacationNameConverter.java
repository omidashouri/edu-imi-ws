package edu.imi.ir.eduimiws.utilities.attendance;

import javax.persistence.AttributeConverter;

public class VacationNameConverter implements AttributeConverter<VacationName, Long> {

    @Override
    public Long convertToDatabaseColumn(VacationName attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public VacationName convertToEntityAttribute(Long dbData) {
        if (dbData == null) {
            return null;
        }
        return VacationName.getVacationNameByCode(dbData);
    }
}
