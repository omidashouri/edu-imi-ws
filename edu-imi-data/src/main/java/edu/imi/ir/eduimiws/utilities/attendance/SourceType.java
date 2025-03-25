package edu.imi.ir.eduimiws.utilities.attendance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import lombok.Getter;

import java.util.Objects;

@Getter
@MappingUtil.SourceTypeConverter
public enum SourceType {
    OPERATOR(1L,"اپراتور"),
    UNKNOWN(-1L,"نامشخص");

    private final Long code;
    private final String name;

    SourceType(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    public static SourceType getSourceTypeByCode(Long code) {
        for (SourceType sourceType : SourceType.values()) {
            if (Objects.equals(sourceType.getCode(), code)) {
                return sourceType;
            }
        }
        return SourceType.UNKNOWN;
    }

    @JsonCreator
    @MappingUtil.SourceTypeByName
    public static SourceType getSourceTypeByName(String name) {
        for (SourceType recordIoType : SourceType.values()) {
            if (recordIoType.getName().equalsIgnoreCase(name)) {
                return recordIoType;
            }
        }
        return SourceType.UNKNOWN;
    }

    @JsonValue
    public String toValue() {
        for (SourceType sourceType : SourceType.values()) {
            if (sourceType == this)
                return sourceType.getName();
        }
        return SourceType.UNKNOWN.getName();
    }
}
