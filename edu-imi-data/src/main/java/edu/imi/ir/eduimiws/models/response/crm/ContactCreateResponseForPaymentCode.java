package edu.imi.ir.eduimiws.models.response.crm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import edu.imi.ir.eduimiws.models.response.v2.BaseResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "contactCreateResponseForPaymentCode",
        description = "Contact create for payment code response (logged POST)")
@JsonRootName(value = "contactResponseForPaymentCode")
@Relation(collectionRelation = "contactResponseForPaymentCodes")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class ContactCreateResponseForPaymentCode extends BaseResponseDto {

    @Schema(title = "Contact Public Id", maxLength = 36)
    private String contactPublicId;

    @Schema(title = "National Code", maxLength = 20)
    private String nationCode;

    @Schema(title = "Full Name", maxLength = 700)
    private String fullName;

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
