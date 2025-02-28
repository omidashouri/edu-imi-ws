package edu.imi.ir.eduimiws.utilities.attendance;

import com.fasterxml.jackson.annotation.JsonCreator;
import edu.imi.ir.eduimiws.mapper.MappingUtil;

import java.util.Objects;

@MappingUtil.IoSourceTypeConverter
public enum IoSourceType {
    OPERATOR(1L,"اپراتور");

    private Long code;
    private String name;

    private IoSourceType(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static IoSourceType getIoSourceTypeByCode(Long code) {
        for (IoSourceType ioSourceType : IoSourceType.values()) {
            if (Objects.equals(ioSourceType.getCode(), code)) {
                return ioSourceType;
            }
        }
        return null;
    }

    @JsonCreator
    @MappingUtil.IoSourceTypeByName
    public static IoSourceType getIoSourceTypeByName(String name) {
        for (IoSourceType recordIoType : IoSourceType.values()) {
            if (recordIoType.getName().equalsIgnoreCase(name)) {
                return recordIoType;
            }
        }
        return null;
    }
}
