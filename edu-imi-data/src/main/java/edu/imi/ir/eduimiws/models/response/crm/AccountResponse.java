package edu.imi.ir.eduimiws.models.response.crm;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "accounts", description = "Class representing a account in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "account")
@Relation(collectionRelation = "accounts")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse extends RepresentationModel<AccountResponse> {


    @Schema(title = "account Public Id", maxLength = 36)
    private String accountPublicId;

    @Schema(title = "company Public Id", maxLength = 36)
    private String companyPublicId;

    @Schema(title = "parent account Public Id", maxLength = 36)
    private String parentAccountPublicId;

    @Schema(title = "primary contact Public Id", maxLength = 36)
    private String primaryContactPublicId;

    @Schema(title = "Relation Type Id",type = "number")
    private Long relationTypeId;

    @Schema(title = "language Public Id", maxLength = 36)
    private String languagePublicId;

    @Schema(title = "currency Public Id", maxLength = 36)
    private String currencyPublicId;

    @Schema(title = "account name", maxLength = 500)
    private String accountName;

    @Schema(title = "account number", maxLength = 20)
    private String accountNumber;

    @Schema(title = "owner ship", maxLength = 1)
    private String ownership;

    @Schema(title = "account type", maxLength = 1)
    private String accountType;

    @Schema(title = "main phone", maxLength = 100)
    private String mainPhone;

    @Schema(title = "other phone", maxLength =25)
    private String otherPhone;

    @Schema(title = "fax number", maxLength = 40)
    private String faxNumber;

    @Schema(title = "web site", maxLength = 30)
    private String webSite;

    @Schema(title = "email", maxLength = 50)
    private String email;

    @Schema(title = "ticker symbol", maxLength = 50)
    private String tickerSymbol;

    @Schema(title = "employees", type = "number")
    private String employees;

    @Schema(title = "annual revenue", type = "number")
    private String annualRevenue;

    @Schema(title = "country Public Id", maxLength = 36)
    private String countryPublicId;

    @Schema(title = "state Public Id", maxLength = 36)
    private String statePublicId;

    @Schema(title = "city Public Id", maxLength = 36)
    private String cityPublicId;

    @Schema(title = "address phone", maxLength = 200)
    private String addressPhone;

    @Schema(title = "address", maxLength = 500)
    private String address;

    @Schema(title = "description", maxLength = 4000)
    private String description;

    @Schema(title = "industry Public Id", type = "number")
    private Long industryId;

    @Schema(title = "address type Public Id", type="number")
    private String addressTypePublicId;

    @Schema(title = "account logo", maxLength = 100)
    private String accountLogo;

    @Schema(title = "print logo", maxLength = 100)
    private String printLogo;

    @Schema(title = "print title 1", maxLength = 200)
    private String printTitle1;

    @Schema(title = "print title 2", maxLength = 200)
    private String printTitle2;

    @Schema(title = "print title 3", maxLength = 200)
    private String printTitle3;

    @Schema(title = "print address title", maxLength = 100)
    private String printAddressTitle;

    @Schema(title = "region public id", maxLength = 36)
    private String regionPublicId;

    @Schema(title = "user creator Public Id", maxLength = 36)
    private String userCreatorPublicId;

    @Schema(title = "create date", maxLength = 10)
    private String createDate;

    @Schema(title = "user last editor Public Id", maxLength = 36)
    private String userLastEditorPublicId;

    @Schema(title = "last edit date", maxLength = 10)
    private String lastEditDate;

    @Schema(title = "user follower Public Id", maxLength = 36)
    private String userFollowerPublicId;

    @Schema(title = "general code", maxLength = 30)
    private String generalCode;

    @Schema(title = "specific code", maxLength = 30)
    private String specificCode;

    @Schema(title = "detailed code", maxLength = 30)
    private String detailedCode;

    @Schema(title = "primary sales man Public Id", maxLength = 36)
    private String primarySalesManId;

    @Schema(title = "secondary sales man Public Id", maxLength = 36)
    private String secondarySalesManId;

    @Schema(title = "path Id", type = "number")
    private String pathId;

    @Schema(title = "access type", maxLength = 10)
    private String accessType;

    @Schema(title = "verified", maxLength = 1)
    private String verified;

    @Schema(title = "account additional info Public Id", maxLength = 36)
    private Long accountAdditionalInfoId;

    @Schema(title = "address 2", maxLength = 500)
    private String address2;

    @Schema(title = "address 3", maxLength = 500)
    private String address3;

    @Schema(title = "account en name", maxLength = 70)
    private String accountEnName;

    @Schema(title = "stock type", maxLength = 10)
    private String stockType;

    @Schema(title = "is holding", maxLength = 1)
    private String isHolding;

    @Schema(title = "organization type Public Id", maxLength = 36)
    private Long orgTypeId;

    @Schema(title = "type of activity", maxLength = 200)
    private String typeOfActivity;

    @Schema(title = "is in stock", maxLength = 1)
    private String isInStock;

    @Schema(title = "utilization year", maxLength = 4)
    private String utilizationYear;

    @Schema(title = "site phone", maxLength = 20)
    private String sitePhone;

    @Schema(title = "site fax", maxLength = 20)
    private String siteFax;

    @Schema(title = "site address", maxLength = 250)
    private String siteAddress;

    @Schema(title = "stock holders", maxLength = 400)
    private String stockHolders;

    @Schema(title = "inpea additional info Public Id", maxLength = 36)
    private String inpeaAdditionalInfo;

    @Schema(title = "sub system", maxLength = 10)
    private String subSys;

    @Schema(title = "ibmc additional info", type = "number")
    private Long ibmcAdditionalInfo;

    @Schema(title = "site city Public Id", maxLength = 36)
    private String siteCityPublicId;

    @Schema(title = "site state Public Id", maxLength = 36)
    private String siteStatePublicId;

    @Schema(title = "stock other type", maxLength = 50)
    private String stockOtherType;

    @Schema(title = "post code", maxLength = 50)
    private String postCode;

    @Schema(title = "pre phone", maxLength = 5)
    private String prePhone;

    @Schema(title = "economical code", maxLength = 50)
    private String economicalCode;

    @Schema(title = "organization national code", maxLength = 50)
    private String orgNationalCode;

    @Schema(title = "employee Public Id", maxLength = 36)
    private String employeePublicId;

    @Schema(title = "annual revenue Public Id", maxLength = 36)
    private String annualRevenueEntityPublicId;

}
