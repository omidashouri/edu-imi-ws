package edu.imi.ir.eduimiws.models.request.crm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;


@Schema(name = "contactRequestForPaymentCode", description = "Class representing a contact in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "contactRequestForPaymentCode")
@Relation(collectionRelation = "contactRequestForPaymentCodes")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequestForPaymentCode extends RepresentationModel<ContactRequestForPaymentCode> {

    @Schema(title = "Contact Public Id", maxLength = 36)
    private String contactPublicId;

    @Schema(title = "National Code", maxLength = 20)
    private String nationCode;

    @Schema(title = "First Name", maxLength = 500)
    private String firstName;

    @Schema(title = "Middle name", maxLength = 100)
    private String middleName;

    @Schema(title = "Last Name", maxLength = 100)
    private String lastName;

    @Schema(title = "Birth Date", maxLength = 11)
    private String birthdate;

    @Schema(title = "Mobile Phone", maxLength = 50)
    private String mobilePhone;

}
