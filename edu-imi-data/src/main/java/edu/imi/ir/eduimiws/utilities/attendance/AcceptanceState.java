package edu.imi.ir.eduimiws.utilities.attendance;

import com.fasterxml.jackson.annotation.JsonCreator;
import edu.imi.ir.eduimiws.mapper.MappingUtil;

import java.util.Objects;
@MappingUtil.AcceptanceStateConverter
public enum AcceptanceState {
    Approved(1L,"تایید شده");

    private Long code;
    private String name;

    private AcceptanceState(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static AcceptanceState getAcceptanceStateByCode(Long code) {
        for (AcceptanceState acceptanceState : AcceptanceState.values()) {
            if (Objects.equals(acceptanceState.getCode(), code)) {
                return acceptanceState;
            }
        }
        return null;
    }

    @JsonCreator
    @MappingUtil.AcceptanceStateByName
    public static AcceptanceState getAcceptanceStateByName(String name) {
        for (AcceptanceState acceptanceState : AcceptanceState.values()) {
            if (acceptanceState.getName().equalsIgnoreCase(name)) {
                return acceptanceState;
            }
        }
        return null;
    }
}
