package edu.imi.ir.eduimiws.models.projections.edu;

import lombok.Value;

@Value
public class StudentOnly {

    Long id;
    Long personId;
    Long deleteStatus;
    Long activityStatus;
    String editDate;
}
