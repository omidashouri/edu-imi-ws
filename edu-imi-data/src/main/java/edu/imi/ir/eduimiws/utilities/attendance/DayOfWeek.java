package edu.imi.ir.eduimiws.utilities.attendance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import lombok.Getter;

import java.util.Objects;

@Getter
@MappingUtil.DayOfWeekConverter
public enum DayOfWeek {
    SATURDAY(1L,"saturday","شنبه"),
    SUNDAY(2L,"sunday","یکشنبه"),
    MONDAY(3L,"monday","دوشنبه"),
    TUESDAY(4L,"tuesday","سه شنبه"),
    WEDNESDAY(5L,"wednesday","چهارشنبه"),
    THURSDAY(6L,"thursday","پنج شنبه"),
    FRIDAY(7L,"friday","جمعه"),
    UNKNOWN(-1L,"unknown","نامشخص");

    private final Long code;
    private final String englishName;
    private final String persianName;

    DayOfWeek(Long code, String englishName, String persianName) {
        this.code = code;
        this.englishName = englishName;
        this.persianName = persianName;
    }

    public static DayOfWeek getDayOfWeekByCode(Long code) {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (Objects.equals(dayOfWeek.getCode(), code)) {
                return dayOfWeek;
            }
        }
        return DayOfWeek.UNKNOWN;
    }

    public static DayOfWeek getDayOfWeekByEnglishName(String englishName) {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek.getEnglishName().equalsIgnoreCase(englishName)) {
                return dayOfWeek;
            }
        }
        return DayOfWeek.UNKNOWN;
    }

    @JsonCreator
    @MappingUtil.DayOfWeekByPersianName
    public static DayOfWeek getDayOfWeekByPersianName(String persianName) {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek.getPersianName().equalsIgnoreCase(persianName)) {
                return dayOfWeek;
            }
        }
        return DayOfWeek.UNKNOWN;
    }

    @JsonValue
    public String toValue() {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek == this)
                return dayOfWeek.getPersianName();
        }
        return DayOfWeek.UNKNOWN.getPersianName();
    }
}
