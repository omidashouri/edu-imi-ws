package edu.imi.ir.eduimiws.utilities.attendance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import lombok.Getter;

import java.util.Objects;

@Getter
@MappingUtil.IoSourceTypeConverter
public enum IoSourceType {
    OPERATOR(1L,"اپراتور"),
    UNKNOWN(-1L,"نامشخص");

    private final Long code;
    private final String name;

    IoSourceType(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    public static IoSourceType getIoSourceTypeByCode(Long code) {
        for (IoSourceType ioSourceType : IoSourceType.values()) {
            if (Objects.equals(ioSourceType.getCode(), code)) {
                return ioSourceType;
            }
        }
        return IoSourceType.UNKNOWN;
    }

    @JsonCreator
    @MappingUtil.IoSourceTypeByName
    public static IoSourceType getIoSourceTypeByName(String name) {
        for (IoSourceType recordIoType : IoSourceType.values()) {
            if (recordIoType.getName().equalsIgnoreCase(name)) {
                return recordIoType;
            }
        }
        return IoSourceType.UNKNOWN;
    }

    @JsonValue
    public String toValue() {
        for (IoSourceType ioSourceType : IoSourceType.values()) {
            if (ioSourceType == this)
                return ioSourceType.getName();
        }
        return IoSourceType.UNKNOWN.getName();
    }
}
