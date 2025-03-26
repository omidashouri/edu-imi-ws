package edu.imi.ir.eduimiws.utilities.attendance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Objects;

@Getter
public enum VacationType {

    DAILY(1L, "روزانه"),
    HOURLY(2L, "ساعتی"),
    UNKNOWN(-1L, "نامشخص");

    private final Long code;
    private final String name;

    VacationType(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    public static VacationType getVacationTypeByCode(Long code) {
        for (VacationType vacationType : VacationType.values()) {
            if (Objects.equals(vacationType.getCode(), code)) {
                return vacationType;
            }
        }
        return VacationType.UNKNOWN;
    }

    @JsonCreator
    public static VacationType getVacationTypeByName(String name) {
        for (VacationType vacationType : VacationType.values()) {
            if (vacationType.getName().equalsIgnoreCase(name)) {
                return vacationType;
            }
        }
        return VacationType.UNKNOWN;
    }

    @JsonValue
    public String toValue() {
        for (VacationType vacationType : VacationType.values()) {
            if (vacationType == this)
                return vacationType.getName();
        }
        return VacationType.UNKNOWN.getName();
    }
}
