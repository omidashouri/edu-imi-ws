package edu.imi.ir.eduimiws.utilities.attendance;


import com.fasterxml.jackson.annotation.JsonCreator;
import edu.imi.ir.eduimiws.mapper.MappingUtil;

import java.util.Objects;

@MappingUtil.RecordIoTypeConverter
public enum RecordIoType {
    ENTRANCE(1L,"ورود"),
    EXIT(0L,"خروج");

    private Long code;
    private String name;

    private RecordIoType(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static RecordIoType getRecordIoTypeByCode(Long code) {
        for (RecordIoType recordIoType : RecordIoType.values()) {
            if (Objects.equals(recordIoType.getCode(), code)) {
                return recordIoType;
            }
        }
        return null;
    }

    @JsonCreator
    @MappingUtil.RecordIoTypeByName
    public static RecordIoType getRecordIoTypeByName(String name) {
        for (RecordIoType recordIoType : RecordIoType.values()) {
            if (recordIoType.getName().equalsIgnoreCase(name)) {
                return recordIoType;
            }
        }
        return null;
    }
}
