package edu.imi.ir.eduimiws.utilities.attendance;

import javax.persistence.AttributeConverter;

public class AcceptanceStateConverter implements AttributeConverter<AcceptanceState, Long> {

    @Override
    public Long convertToDatabaseColumn(AcceptanceState attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public AcceptanceState convertToEntityAttribute(Long dbData) {
        if (dbData == null) {
            return null;
        }
        return AcceptanceState.getAcceptanceStateByCode(dbData);
    }
}
