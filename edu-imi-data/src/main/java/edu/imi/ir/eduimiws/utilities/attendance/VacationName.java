package edu.imi.ir.eduimiws.utilities.attendance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import lombok.Getter;

import java.util.Objects;

@Getter
@MappingUtil.VacationNameConverter
public enum VacationName {

    DAILY_PAID_LEAVE(1L, "مرخصی استحقاقی روزانه"),
    HOURLY_PAID_LEAVE(2L, "مرخصی استحقاقی ساعتی"),
    DAILY_SICK_LEAVE_WITH_PAY(3L, "مرخصی استعلاجی با حقوق روزانه"),
    HOURLY_SICK_LEAVE_WITH_PAY(4L, "مرخصی استعلاجی با حقوق ساعتی"),
    DAILY_SICK_LEAVE_WITHOUT_PAY(5L, "مرخصی استعلاجی بدون حقوق روزانه"),
    HOURLY_SICK_LEAVE_WITHOUT_PAY(6L, "مرخصی استعلاجی بدون حقوق ساعتی"),
    DAILY_LEAVE_WITHOUT_PAY(7L, "مرخصی بدون حقوق روزانه"),
    HOURLY_LEAVE_WITHOUT_PAY(8L, "مرخصی بدون حقوق ساعتی"),
    DAILY_STUDENT_LEAVE_WITH_PAY(9L, "مرخصی دانشجویی با حقوق روزانه"),
    HOURLY_STUDENT_LEAVE_WITH_PAY(10L, "مرخصی دانشجویی با حقوق ساعتی"),
    DAILY_STUDENT_LEAVE_WITHOUT_PAY(11L, "مرخصی دانشجویی بدون حقوق روزانه"),
    HOURLY_STUDENT_LEAVE_WITHOUT_PAY(12L, "مرخصی دانشجویی بدون حقوق ساعتی"),
    HOURLY_VETERANS_LEAVE(13L, "مرخصی جانبازی ساعتی"),
    HOURLY_BREASTFEEDING_LEAVE(14L, "مرخصی شیردهی ساعتی"),
    DAILY_MATERNITY_LEAVE(15L, "مرخصی زایمان روزانه"),
    UNKNOWN(-1L, "نامشخص");


    private final Long code;
    private final String name;

    VacationName(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    public static VacationName getVacationNameByCode(Long code) {
        for (VacationName vacationName : VacationName.values()) {
            if (Objects.equals(vacationName.getCode(), code)) {
                return vacationName;
            }
        }
        return VacationName.UNKNOWN;
    }

    @MappingUtil.VacationNameByName
    @JsonCreator
    public static VacationName getVacationNameByName(String name) {
        for (VacationName vacationName : VacationName.values()) {
            if (vacationName.getName().equalsIgnoreCase(name)) {
                return vacationName;
            }
        }
        return VacationName.UNKNOWN;
    }

    @JsonValue
    public String toValue() {
        for (VacationName vacationName : VacationName.values()) {
            if (vacationName == this)
                return vacationName.getName();
        }
        return VacationName.UNKNOWN.getName();
    }
}
