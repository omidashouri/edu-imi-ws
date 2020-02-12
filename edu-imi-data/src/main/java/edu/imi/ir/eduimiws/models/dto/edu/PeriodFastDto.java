package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.domain.crm.AccountEntity;
import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import edu.imi.ir.eduimiws.domain.crm.OrganizationEntity;
import edu.imi.ir.eduimiws.domain.edu.FieldEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeriodFastDto implements Serializable {

    private static final long serialVersionUID = -1350326709463048085L;

    private String name;

    private String startDate;

    private String endDate;

    private FieldEntity field;

    private String type;

    private Long fee;

    private Long offerNumber;

    private String createDate;

    private String editDate;

    private Long activityStatus;

    private Long deleteStatus;

    private Long presentType;

    private String tempType;

    private String maxCapacity;

    private String minCapacity;

    private OrganizationEntity organization;

    private Long planId;

    private AccountEntity account;

    private Long totalUnit;

    private String thesisUnit;

    private Long tunit;

    private String punit;

    private String variableName;

    private Long certificateTemplateId;

    private Long executerCapacity;

    private Long feeForeign;

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

    private String allowTerm;

    private String variableCertificateName;


}
