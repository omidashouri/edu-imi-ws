package edu.imi.ir.eduimiws.models.response.crm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;


@Schema(name = "contacts", description = "Class representing a contact in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "contact")
@Relation(collectionRelation = "contacts")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponse extends RepresentationModel<UserContactResponse> {

    @Schema(title = "Contact Public Id", maxLength = 36)
    private String contactPublicId;

    @Schema(title = "User Public Id", maxLength = 36)
    private String userPublicId;

    @Schema(title = "Account Public ID", maxLength = 36)
    private Long accountPublicId;

    @Schema(title = "Salutation Public Id", maxLength = 36)
    private Long salutationPublicId;

    @Schema(title = "First Name", maxLength = 500)
    private String firstName;

    @Schema(title = "Middle name", maxLength = 100)
    private String middleName;

    @Schema(title = "Last Name", maxLength = 100)
    private String lastName;

    @Schema(title = "Job Title", maxLength = 250)
    private String jobTitle;

    @Schema(title = "Business Phone", maxLength = 50)
    private String businessPhone;

    @Schema(title = "Home Phone", maxLength = 50)
    private String homePhone;

    @Schema(title = "Mobile Phone", maxLength = 50)
    private String mobilePhone;

    @Schema(title = "Fax Number", maxLength = 50)
    private String faxNumber;

    @Schema(title = "Pager Number", maxLength = 50)
    private String pagerNumber;

    @Schema(title = "Email", maxLength = 100)
    private String email;

    @Schema(title = "Currency Public Id", maxLength = 36)
    private Long currencyPublicId;

    @Schema(title = "Department Name", maxLength = 100)
    private String department;

    @Schema(title = "Role Name", maxLength = 100)
    private String role;

    @Schema(title = "Manager Public ID", maxLength = 36)
    private Long managerPublicId;

    @Schema(title = "Manager Phone", maxLength = 50)
    private String managerPhone;

    @Schema(title = "Assistance Public Id", maxLength = 36)
    private Long assistantPublicId;

    @Schema(title = "Assistance Phon", maxLength = 50)
    private String assistantPhone;

    @Schema(title = "Gender", maxLength = 3)
    private String gender;

    @Schema(title = "Marital Status", maxLength = 1)
    private String maritalStatus;

    @Schema(title = "Partner Name", maxLength = 200)
    private String partnerName;

    @Schema(title = "Birth Date", maxLength = 20)
    private String birthdate;

    @Schema(title = "Anniversary", maxLength = 20)
    private String anniversary;

    @Schema(title = "Description", maxLength = 4000)
    private String description;

    @Schema(title = "Parent Public ID", maxLength = 36)
    private Long parentPublicId;

    @Schema(title = "Country Public Id", maxLength = 36)
    private Long countryPublicId;

    @Schema(title = "State Public Id", maxLength = 36)
    private Long statePublicId;

    @Schema(title = "City Public Id", maxLength = 36)
    private Long cityPublicId;

    @Schema(title = "Address Phone", maxLength = 500)
    private String addressPhone;

    @Schema(title = "Address", maxLength = 500)
    private String address;

    @Schema(title = "Company Public Id", maxLength = 36)
    private Long companyPublicId;

    @Schema(title = "Organization Public Id", maxLength = 36)
    private Long organizationPublicId;

    @Schema(title = "Lead Source public Id", maxLength = 36)
    private Long leadSourcePublicId;

    @Schema(title = "Campaign Public ID", maxLength = 36)
    private Long campaignPublicId;

    @Schema(title = "Team Public Id", maxLength = 36)
    private Long teamPublicId;

    @Schema(title = "Sync Outlook", maxLength = 1)
    private String syncOutLook;

    @Schema(title = "predefined Contact Method", maxLength = 1)
    private String preferredContactMethod;

    @Schema(title = "Allow Email", maxLength = 1)
    private String allowEmail;

    @Schema(title = "Allow Bulk Email", maxLength = 1)
    private String allowBulkEmail;

    @Schema(title = "Allow Phone", maxLength = 1)
    private String allowPhone;

    @Schema(title = "Allow Fax", maxLength = 1)
    private String allowFax;

    @Schema(title = "Allow Mail", maxLength = 1)
    private String allowMail;

    @Schema(title = "Address Type Public Id", maxLength = 36)
    private Long addressTypePublicId;

    @Schema(title = "User Creator Public Id", maxLength = 36)
    private Long userCreatorPublicId;

    @Schema(title = "From City", maxLength = 100)
    private String fromCity;

    @Schema(title = "Certificate Number", maxLength = 100)
    private String certificateNo;

    @Schema(title = "National Code", maxLength = 20)
    private String nationCode;

    @Schema(title = "Father Name", maxLength = 100)
    private String fatherName;

    @Schema(title = "Birth City Public Id", maxLength = 36)
    private Long birthCityPublicId;

    @Schema(title = "Access Type", maxLength = 10)
    private String accessType;

    @Schema(title = "Image", maxLength = 200)
    private String image;

    @Schema(title = "Latin First Name", maxLength = 50)
    private String lfirstName;

    @Schema(title = "Latin Last Name", maxLength = 50)
    private String llastName;

    @Schema(title = "Religion Public Id", maxLength = 36)
    private Long religionPublicId;

    @Schema(title = "Military Service Public Id", maxLength = 36)
    private Long militaryServicePublicId;

    @Schema(title = "Education Level Public Id", maxLength = 36)
    private Long eduLevelPublicId;

    @Schema(title = "Field Name", maxLength = 200)
    private String fieldName;

    @Schema(title = "Bank Name", maxLength = 50)
    private String bankName;

    @Schema(title = "Branch Name", maxLength = 50)
    private String branchName;

    @Schema(title = "Bank Account Number", maxLength = 30)
    private String bankAccountNumber;

    @Schema(title = "Bank Account Type", maxLength = 50)
    private String bankAccoountType;

    @Schema(title = "Entrance Date", maxLength = 10)
    private String entranceDate;

    @Schema(title = "Contract Type Public Id", maxLength = 36)
    private Long contractTypePublicId;

    @Schema(title = "University", maxLength = 300)
    private String university;

    @Schema(title = "Insurance Kind Public Id", maxLength = 36)
    private Long insuranceKindPublicId;

    @Schema(title = "Insurance Box Public Id", maxLength = 36)
    private Long insuranceBoxPublicId;

    @Schema(title = "Latin Gender", maxLength = 10)
    private String gender1;

    @Schema(title = "Latin Marital", maxLength = 10)
    private String marital1;

    @Schema(title = "Latin Military", maxLength = 50)
    private String military1;

    @Schema(title = "Edit Temp Row Flag", maxLength = 1)
    private String editTempRowFlag;

    @Schema(title = "Create Temp Row Flag", maxLength = 1)
    private String createTempRowFlag;

    @Schema(title = "Verified Status", maxLength = 1)
    private String verified;

    @Schema(title = "Postal Code", maxLength = 20)
    private String postalCode;

    @Schema(title = "Edit Date", maxLength = 10)
    private String editDate;

    @Schema(title = "Create Date", maxLength = 10)
    private String createDate;

    @Schema(title = "User Editor Public Id", maxLength = 36)
    private Long userEditorPublicId;

    @Schema(title = "Convert Date Who", maxLength = 30)
    private String convertDateWho;

    @Schema(title = "Convert Unique", maxLength = 20)
    private String convertUniq;

    @Schema(title = "Latin Father NAme", maxLength = 50)
    private String lfatherName;

    @Schema(title = "Latin From City", maxLength = 100)
    private String lfromCity;

    @Schema(title = "Latin From City Public ID", maxLength = 36)
    private Long lfromCityEntityPublicId;

}
