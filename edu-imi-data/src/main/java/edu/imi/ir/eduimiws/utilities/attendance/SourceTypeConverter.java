package edu.imi.ir.eduimiws.utilities.attendance;

import javax.persistence.AttributeConverter;

public class SourceTypeConverter implements AttributeConverter<SourceType, Long> {

    @Override
    public Long convertToDatabaseColumn(SourceType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public SourceType convertToEntityAttribute(Long dbData) {
        if (dbData == null) {
            return null;
        }
        return SourceType.getSourceTypeByCode(dbData);
    }
}
