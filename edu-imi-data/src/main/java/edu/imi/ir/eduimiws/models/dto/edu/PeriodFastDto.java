package edu.imi.ir.eduimiws.models.dto.edu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodFastDto implements Serializable {

//    use when define @Transient filed in Entity and select with @NamedEntityGraph

    private static final long serialVersionUID = -1350326709463048085L;

    @Schema(
            description = "period name"
    )
    private String name;

    @Schema(
            description = "period start date"
    )
    private String startDate;

    @Schema(
            description = "period end date"
    )
    private String endDate;

    private Long fieldId;

    private String type;

    @Schema(
            description = "period fee"
    )
    private Long fee;

    @Schema(
            description = "period number"
    )
    private Long offerNumber;
    @Schema(
            description = "creator id"
    )
    private Long creatorId;

    @Schema(
            description = "create date"
    )
    private String createDate;

    private Long editorId;

    private String editDate;

    private Long activityStatus;

    private Long deleteStatus;

    private Long presentType;

    private String tempType;

    private Long maxCapacity;

    private Long minCapacity;

    private Long organizationId;

    private Long executerId;

    private Long academicId;

    private Long planId;

    private Long accountId;

    private Long totalUnit;

    private String thesisUnit;

    private Long tunit;

    private Long punit;

    private String variableName;

    private Long certificateTemplateId;

    private Long executerCapacity;

    private Long feeForeign;

    private Long currencyId;

    private String regStartDate;

    private String regEndDate;

    private String description;

    private String schedule;

    private Long periodOrgFee;

    private Long companyId;

    private String canRegisterOnline;

    private String cardNoPerfix;

    private Long feeVariable;

    private Long feeEquivalentFixed;

    private Long feeEquivalentVariable;

    private Long onlineRegCostPercent;

    private String cardNoPerfixR;

    private Long periodHoldingId;

    private String holdingType;

    private String holdingLanguage;

    private String certificateDesc;

    private Long allowTerm;

    private Long cityId;

    private String variableCertificateName;


}
