package edu.imi.ir.eduimiws.models.projections.edu;

import lombok.Value;

@Value
public class PeriodProjectionCustomOne {

    String fieldPublicId;
    String eduCategoryPublicId;
    String fieldCode;
    Long periodOfferNumber;
    String periodName;
    String fieldFName;
    String eduCategoryTitle;
    String periodStartDate;
    String periodEndDate;
    String periodRegisterStartDate;
    String periodRegisterEndDate;
    Long periodMaxCapacity;
    String periodHoldingType;
    String periodCanRegisterOnline;
    String periodType;
    Long periodFee;
    String periodSchedule;
    Long periodActivityStatus;
    Long periodDeleteStatus;
    String executorFirstName;
    String executorLastName;
}
