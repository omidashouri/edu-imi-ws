package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodFastDto implements Serializable {

    private static final long serialVersionUID = 631680441610385751L;

    //   for Descriptive (begin) :
    private Long eduCategoryId;
    private String eduCategoryPublicId;
    private String eduCategoryTitle;
    private Long levelId;
    private String levelPublicId;
    private String levelDescription;
    private String fieldFName;
    private String fieldLName;
//   for Descriptive (end) :

    private Long id;

    private String periodPublicId;

    private String name;

    private String startDate;

    private String endDate;

    private Long fieldId;

    private String fieldPublicId;

    private String type;

    private Long fee;

    private Long offerNumber;

    private Long creatorId;

    private String creatorPublicId;

    private String createDate;

    private Long editorId;

    private String editorPublicId;

    private String editDate;

    private Long activityStatus;

    private Long deleteStatus;

    private Long presentType;

    private String tempType;

    private Long maxCapacity;

    private Long minCapacity;

    private Long organizationId;

    private String organizationPublicId;

    private Long executerId;

    private String executorPublicId;

    private String executorFullName;

    private Long academicId;

    private String academicPublicId;

    private Long planId;

    private String planPublicId;

    private Long accountId;

    private String accountPublicId;

    private Long totalUnit;

    private String thesisUnit;

    private Long tunit;

    private Long punit;

    private String variableName;

    private Long certificateTemplateId;

    private Long executerCapacity;

    private Long feeForeign;

    private Long currencyId;

    private String currencyPublicId;

    private String regStartDate;

    private String regEndDate;

    private String description;

    private String schedule;

    private Long periodOrgFee;

    private Long companyId;

    private String companyPublicId;

    private String canRegisterOnline;

    private String cardNoPerfix;

    private Long feeVariable;

    private Long feeEquivalentFixed;

    private Long feeEquivalentVariable;

    private Long onlineRegCostPercent;

    private String cardNoPerfixR;

    private Long periodHoldingId;

    private String periodHoldingPublicId;

    private String holdingType;

    private String holdingLanguage;

    private String certificateDesc;

    private Long allowTerm;

    private Long cityId;

    private String cityPublicId;

    private String variableCertificateName;


}
