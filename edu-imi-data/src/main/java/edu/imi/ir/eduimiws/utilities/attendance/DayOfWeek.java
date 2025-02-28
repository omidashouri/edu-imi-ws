package edu.imi.ir.eduimiws.utilities.attendance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import edu.imi.ir.eduimiws.mapper.MappingUtil;

import java.util.Objects;

@MappingUtil.DayOfWeekConverter
public enum DayOfWeek {
    SATURDAY(1L,"saturday","شنبه"),
    SUNDAY(2L,"sunday","شنبه"),
    MONDAY(3L,"monday","شنبه"),
    TUESDAY(4L,"tuesday","شنبه"),
    WEDNESDAY(5L,"wednesday","شنبه"),
    THURSDAY(6L,"thursday","شنبه"),
    FRIDAY(7L,"friday","شنبه");

    private final Long code;
    private final String englishName;
    private final String persianName;

    private DayOfWeek(Long code, String englishName, String persianName) {
        this.code = code;
        this.englishName = englishName;
        this.persianName = persianName;
    }

    public Long getCode() {
        return code;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getPersianName() {
        return persianName;
    }

    public static DayOfWeek getDayOfWeekByCode(Long code) {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (Objects.equals(dayOfWeek.getCode(), code)) {
                return dayOfWeek;
            }
        }
        return null;
    }

    public static DayOfWeek getDayOfWeekByEnglishName(String englishName) {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek.getEnglishName().equalsIgnoreCase(englishName)) {
                return dayOfWeek;
            }
        }
        return null;
    }

    @JsonCreator
    @MappingUtil.DayOfWeekByPersianName
    public static DayOfWeek getDayOfWeekByPersianName(String persianName) {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek.getPersianName().equalsIgnoreCase(persianName)) {
                return dayOfWeek;
            }
        }
        return null;
    }
}
