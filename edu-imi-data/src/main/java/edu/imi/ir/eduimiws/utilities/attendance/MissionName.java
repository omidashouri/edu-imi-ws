package edu.imi.ir.eduimiws.utilities.attendance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import lombok.Getter;

import java.util.Objects;

@Getter
@MappingUtil.MissionNameConverter
public enum MissionName {

    DAILY_MISSION_IN_CENTER(1L, "ماموریت داخل مرکز روزانه"),
    HOURLY_MISSION_IN_CENTER(2L, "ماموریت داخل مرکز ساعتی"),
    DAILY_MISSION_OUT_CENTER(3L, "ماموریت خارج مرکز روزانه"),
    HOURLY_MISSION_OUT_CENTER(4L, "ماموریت خارج مرکز ساعتی"),
    UNKNOWN(-1L, "نامشخص");

    private final Long code;
    private final String name;

    MissionName(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    public static MissionName getMissionNameByCode(Long code) {
        for (MissionName missionName : MissionName.values()) {
            if (Objects.equals(missionName.getCode(), code)) {
                return missionName;
            }
        }
        return MissionName.UNKNOWN;
    }

    @MappingUtil.MissionNameByName
    @JsonCreator
    public static MissionName getMissionNameByName(String name) {
        for (MissionName missionName : MissionName.values()) {
            if (missionName.getName().equalsIgnoreCase(name)) {
                return missionName;
            }
        }
        return MissionName.UNKNOWN;
    }

    @JsonValue
    public String toValue() {
        for (MissionName missionName : MissionName.values()) {
            if (missionName == this)
                return missionName.getName();
        }
        return MissionName.UNKNOWN.getName();
    }

}
