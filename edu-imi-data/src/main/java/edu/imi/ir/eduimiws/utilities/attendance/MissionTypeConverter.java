package edu.imi.ir.eduimiws.utilities.attendance;

import javax.persistence.AttributeConverter;

public class MissionTypeConverter implements AttributeConverter<MissionType, Long> {

    @Override
    public Long convertToDatabaseColumn(MissionType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public MissionType convertToEntityAttribute(Long dbData) {
        if (dbData == null) {
            return null;
        }
        return MissionType.getMissionTypeByCode(dbData);
    }
}
