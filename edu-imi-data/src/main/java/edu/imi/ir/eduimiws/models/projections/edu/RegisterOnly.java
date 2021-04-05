package edu.imi.ir.eduimiws.models.projections.edu;

import lombok.Value;

@Value
public class RegisterOnly {

    Long id;
    Long periodId;
    Long studentId;
    Long deleteStatus;
    Long activityStatus;
    String registerDate;

}
