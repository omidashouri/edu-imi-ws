package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.domain.crm.*;
import edu.imi.ir.eduimiws.domain.edu.FieldEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodApiEntity;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodDto implements Serializable {

    private static final long serialVersionUID = -921331900990713569L;

    private String name;

    private String startDate;

    private String endDate;

    private FieldEntity field;

    private String type;

    private Long fee;

    private Long offerNumber;

    private PersonEntity creator;

    private String createDate;

    private PersonEntity editor;

    private String editDate;

    private Long activityStatus;

    private Long deleteStatus;

    private Long presentType;

    private String tempType;

    private Long maxCapacity;

    private Long minCapacity;

    private OrganizationEntity organization;

    private PersonEntity executer;

    private PersonEntity academic;

    private Long planId;

    private AccountEntity account;

    private Long totalUnit;

    private String thesisUnit;

    private Long tunit;

    private Long punit;

    private String variableName;

    private Long certificateTemplateId;

    private Long executerCapacity;

    private Long feeForeign;

    private ParameterEntity currency;

    private String regStartDate;

    private String regEndDate;

    private String description;

    private String schedule;

    private Long periodOrgFee;

    private CompanyEntity company;

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

    private ParameterEntity city;

    private String variableCertificateName;

    private PeriodApiEntity periodApi;


}
