package edu.imi.ir.eduimiws.utilities.attendance;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import lombok.Getter;

import java.util.Objects;

@Getter
@MappingUtil.RecordIoTypeConverter
public enum RecordIoType {
    ENTRANCE(1L,"ورود"),
    EXIT(0L,"خروج"),
    UNKNOWN(-1L,"نامشخص");

    private final Long code;
    private final String name;

    RecordIoType(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    public static RecordIoType getRecordIoTypeByCode(Long code) {
        for (RecordIoType recordIoType : RecordIoType.values()) {
            if (Objects.equals(recordIoType.getCode(), code)) {
                return recordIoType;
            }
        }
        return RecordIoType.UNKNOWN;
    }

    @JsonCreator
    @MappingUtil.RecordIoTypeByName
    public static RecordIoType getRecordIoTypeByName(String name) {
        for (RecordIoType recordIoType : RecordIoType.values()) {
            if (recordIoType.getName().equalsIgnoreCase(name)) {
                return recordIoType;
            }
        }
        return RecordIoType.UNKNOWN;
    }

    @JsonValue
    public String toValue() {
        for (RecordIoType recordIoType : RecordIoType.values()) {
            if (recordIoType == this)
                return recordIoType.getName();
        }
        return RecordIoType.UNKNOWN.getName();
    }
}
