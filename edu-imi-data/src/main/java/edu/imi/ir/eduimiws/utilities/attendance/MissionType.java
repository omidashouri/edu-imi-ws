package edu.imi.ir.eduimiws.utilities.attendance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import lombok.Getter;

import java.util.Objects;

@Getter
public enum MissionType {

    DAILY(1L,"روزانه"),
    HOURLY(2L,"ساعتی"),
    UNKNOWN(-1L,"نامشخص");

    private final Long code;
    private final String name;

    MissionType(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    public static MissionType getMissionTypeByCode(Long code) {
        for (MissionType missionType : MissionType.values()) {
            if (Objects.equals(missionType.getCode(), code)) {
                return missionType;
            }
        }
        return MissionType.UNKNOWN;
    }

    @JsonCreator
    public static MissionType getMissionTypeByName(String name) {
        for (MissionType missionType : MissionType.values()) {
            if (missionType.getName().equalsIgnoreCase(name)) {
                return missionType;
            }
        }
        return MissionType.UNKNOWN;
    }

    @JsonValue
    public String toValue() {
        for (MissionType missionType : MissionType.values()) {
            if (missionType == this)
                return missionType.getName();
        }
        return MissionType.UNKNOWN.getName();
    }
}
