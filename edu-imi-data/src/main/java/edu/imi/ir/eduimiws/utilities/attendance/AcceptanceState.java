package edu.imi.ir.eduimiws.utilities.attendance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import lombok.Getter;

import java.util.Objects;
@Getter
@MappingUtil.AcceptanceStateConverter
public enum AcceptanceState {
    APPROVED(1L,"تایید شده"),
    UNKNOWN(-1L,"نامشخص");


    private final Long code;
    private final String name;

    AcceptanceState(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    public static AcceptanceState getAcceptanceStateByCode(Long code) {
        for (AcceptanceState acceptanceState : AcceptanceState.values()) {
            if (Objects.equals(acceptanceState.getCode(), code)) {
                return acceptanceState;
            }
        }
        return AcceptanceState.UNKNOWN;
    }

    @JsonCreator
    @MappingUtil.AcceptanceStateByName
    public static AcceptanceState getAcceptanceStateByName(String name) {
        for (AcceptanceState acceptanceState : AcceptanceState.values()) {
            if (acceptanceState.getName().equalsIgnoreCase(name)) {
                return acceptanceState;
            }
        }
        return AcceptanceState.UNKNOWN;
    }

    @JsonValue
    public String toValue() {
        for (AcceptanceState acceptanceState : AcceptanceState.values()) {
            if (acceptanceState == this)
                return acceptanceState.getName();
        }
        return AcceptanceState.UNKNOWN.getName();
    }
}
