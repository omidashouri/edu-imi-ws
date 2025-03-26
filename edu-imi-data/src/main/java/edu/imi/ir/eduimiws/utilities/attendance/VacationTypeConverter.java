package edu.imi.ir.eduimiws.utilities.attendance;

import javax.persistence.AttributeConverter;

public class VacationTypeConverter implements AttributeConverter<VacationType, Long> {

    @Override
    public Long convertToDatabaseColumn(VacationType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public VacationType convertToEntityAttribute(Long dbData) {
        if (dbData == null) {
            return null;
        }
        return VacationType.getVacationTypeByCode(dbData);
    }
}
