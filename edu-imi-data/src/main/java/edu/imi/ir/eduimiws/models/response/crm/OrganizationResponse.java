package edu.imi.ir.eduimiws.models.response.crm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;


@Schema(name = "organizations", description = "Class representing a organization in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "organization")
@Relation(collectionRelation = "organizations")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationResponse extends RepresentationModel<OrganizationResponse> {

    @Schema(title = "organization Public Id", maxLength = 36)
    private String organizationPublicId;

    @Schema(title = "NAME LO", maxLength = 100)
    private String nameLo;

    @Schema(title = "PARENT Public Id", maxLength = 36)
    private String parentPublicId;

    @Schema(title = "WEBSITE", maxLength = 100)
    private String website;

    @Schema(title = "MAIN_PHONE", maxLength = 20)
    private String mainPhone;

    @Schema(title = "OTHER_PHONE", maxLength = 20)
    private String otherPhone;

    @Schema(title = "FAX", maxLength = 20)
    private String fax;

    @Schema(title = "EMAIL", maxLength = 100)
    private String email;

    @Schema(title = "BILL_ADDRESS", maxLength = 4000)
    private String billAddress;

    @Schema(title = "BILL CITY Public Id", maxLength = 36)
    private String billCityPublicId;

    @Schema(title = "BILL STATE Public Id", maxLength = 36)
    private String billStatePublicId;

    @Schema(title = "BILL COUNTRY Public Id", maxLength = 36)
    private String billCountryPublicId;

    @Schema(title = "BILL ZIP CODE", maxLength = 100)
    private String billZipcode;

    @Schema(title = "SHIP ADDRESS", maxLength = 4000)
    private String shipAddress;

    @Schema(title = "SHIP CITY Public Id", maxLength = 36)
    private String shipCityPublicId;

    @Schema(title = "SHIP STATE Public Id", maxLength = 36)
    private String shipStatePublicId;

    @Schema(title = "SHIP COUNTRY Public Id", maxLength = 36)
    private String shipCountryPublicId;

    @Schema(title = "SHIP ZIP CODE", maxLength = 100)
    private String shipZipcode;


    @Schema(title = "ACCOUNT Public ID", maxLength = 36)
    private String accountPublicId;

    @Schema(title = "IS ACTIVE", maxLength = 1)
    private String isActive;

    @Schema(title = "EDIT DATE", maxLength = 10)
    private String editDate;

}
