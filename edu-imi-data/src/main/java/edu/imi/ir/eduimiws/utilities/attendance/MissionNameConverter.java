package edu.imi.ir.eduimiws.utilities.attendance;

import javax.persistence.AttributeConverter;

public class MissionNameConverter implements AttributeConverter<MissionName, Long> {


    @Override
    public Long convertToDatabaseColumn(MissionName attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public MissionName convertToEntityAttribute(Long dbData) {
        if (dbData == null) {
            return null;
        }
        return MissionName.getMissionNameByCode(dbData);
    }
}
