package edu.imi.ir.eduimiws.models.response.crm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "accountResponseForPaymentCode", description = "Class representing a account in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "accountResponseForPaymentCode")
@Relation(collectionRelation = "accountResponseForPaymentCodes")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseForPaymentCode extends RepresentationModel<AccountResponseForPaymentCode> {

    @Schema(title = "Account Public Id", maxLength = 36)
    private String accountPublicId;

    @Schema(title = "Economical Code", maxLength = 50)
    private String economicalCode;

    @Schema(title = "Account Name", maxLength = 500)
    private String accountName;

    @Schema(title = "Main Phone", maxLength = 100)
    private String mainPhone;

    @Schema(title = "Other Phone (Mobile)", maxLength = 25)
    private String otherPhone;
}
