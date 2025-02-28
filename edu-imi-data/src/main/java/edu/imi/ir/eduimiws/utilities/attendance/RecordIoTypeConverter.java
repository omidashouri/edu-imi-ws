package edu.imi.ir.eduimiws.utilities.attendance;

import javax.persistence.AttributeConverter;

public class RecordIoTypeConverter  implements AttributeConverter<RecordIoType, Long> {

    @Override
    public Long convertToDatabaseColumn(RecordIoType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public RecordIoType convertToEntityAttribute(Long dbData) {
        if (dbData == null) {
            return null;
        }
        return RecordIoType.getRecordIoTypeByCode(dbData);
    }
}
