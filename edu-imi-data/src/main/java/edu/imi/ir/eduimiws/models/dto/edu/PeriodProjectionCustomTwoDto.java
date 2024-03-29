package edu.imi.ir.eduimiws.models.dto.edu;


import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodProjectionCustomTwoDto implements Serializable {

    private static final long serialVersionUID = -6046176349750158040L;

    private String fieldPublicId;

    private String eduCategoryPublicId;

    private String levelPublicId;

    private String fieldCode;

    private Long offerNumber;

    private String levelDescription;

    private String name;

    private String fieldFName;

    private String eduCategoryTitle;

    private String startDate;

    private String endDate;

    private String regStartDate;

    private String regEndDate;

    private Long maxCapacity;

    private String holdingType;

    private String canRegisterOnline;

    private String type;

    private Long fee;

    private Long onlineRegCostPercent;

    private Long feeEquivalentFixed;

    private Long feeEquivalentVariable;

    private String schedule;

    private Long activityStatus;

    private Long deleteStatus;

    private Long totalUnit;

    private Long periodId;

    private String periodPublicId;

    private String executorFirstName;

    private String executorLastName;
    
    private String executorFullName;
}
