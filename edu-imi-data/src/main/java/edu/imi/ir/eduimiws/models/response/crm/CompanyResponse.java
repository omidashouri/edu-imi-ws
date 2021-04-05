package edu.imi.ir.eduimiws.models.response.crm;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;


@Schema(name = "companies", description = "Class representing a company in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "company")
@Relation(collectionRelation = "companies")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResponse extends RepresentationModel<CompanyResponse> {

    @Schema(title = "company Public Id", maxLength = 36)
    private String companyPublicId;

    @Schema(title = "company Public Id", maxLength = 36)
    private String nameLo;

    @Schema(title="PHONE", maxLength =100)
    private String phone;

    @Schema(title="FAX", maxLength =100)
    private String fax;

    @Schema(title="WEB SITE", maxLength =100)
    private String webSite;

    @Schema(title="EMAIL", maxLength =100)
    private String email;

    @Schema(title="BILLING ADDRESS", maxLength =200)
    private String billingAddress;

    @Schema(title="SHIPPING ADDRESS", maxLength =200)
    private String shippingAddress;

    @Schema(title="ANNUAL REVENUE", maxLength =200)
    private String annualRevenue;

    @Schema(title="EMPLOYEES", type = "number")
    private Long employees;

    @Schema(title="OWNERSHIP", maxLength =10)
    private String ownership;

    @Schema(title = "PAREMETER Public Id", maxLength =36)
    private String parameterPublicId;

    @Schema(title="TERRITORY", maxLength =100)
    private String territory;

    @Schema(title = "LANGUAGE Public ID", maxLength =36)
    private String languagePublicId;

    @Schema(title="CALENDER TYPE", maxLength =1)
    private String calenderType;

    @Schema(title = "MAIN ACCOUNT Public ID", maxLength =36)
    private String mainAccountPublicId;

    @Schema(title="IS MAIN", maxLength =1)
    private String isMain;

    @Schema(title="LOGO", maxLength =50)
    private String logo;

}
