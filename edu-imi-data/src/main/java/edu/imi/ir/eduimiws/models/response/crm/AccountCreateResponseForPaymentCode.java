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

@Schema(name = "accountCreateResponseForPaymentCode",
        description = "Account create for payment code response (logged POST)")
@JsonRootName(value = "accountResponseForPaymentCode")
@Relation(collectionRelation = "accountResponseForPaymentCodes")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class AccountCreateResponseForPaymentCode extends BaseResponseDto {

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
