package edu.imi.ir.eduimiws.models.projections.edu;

import lombok.Value;
//___periodfour
@Value
public class PeriodProjectionCustomFour {

    Long id;
    Long offerNumber;
    Long totalUnit;
    Long maxCapacity;
    Long fee;
    Long onlineRegCostPercent;
    Long feeEquivalentFixed;
    Long feeEquivalentVariable;
    Long activityStatus;
    Long deleteStatus;

    String periodPublicId;
    String fieldPublicId;
    String eduCategoryPublicId;
    String levelPublicId;
    String projectPublicId;
    String publicId;

    String code;
    String fName;
    String name;
    String levelTitle;
    String eduCategoryTitle;
    String projectName;

    String depositCode;
    String projectCode;

    String executorFirstName;
    String executorLastName;

    String startDate;
    String endDate;
    String regStartDate;
    String regEndDate;

    String holdingType;
    String canRegisterOnline;
    String type;
    String schedule;

    Long planId;
}
