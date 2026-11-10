package edu.imi.ir.eduimiws.models.request.mainparts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import edu.imi.ir.eduimiws.models.request.v2.BaseRequestDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.hateoas.server.core.Relation;

@Schema(name = "paymentCodeRequest", description = "Class representing a payment code in the application.")
@EqualsAndHashCode(callSuper = true)
@JsonRootName(value = "paymentCodeRequest")
@Relation(collectionRelation = "paymentCodeRequests")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class PaymentCodeRequest extends BaseRequestDto {

    @Schema(title = "national/economic code",
            description = "payer national code", maxLength = 11,
            type = "string", example = " ")
    private String nationalCode;

    @Schema(title = "Expense Code Public Id",
            description = "expense code public Id", maxLength = 36, nullable = true,
            type = "string", example = " ")
    private String expenseCodePublicId;

    @Schema(title = "Expense Code",
            description = "expense code", maxLength = 1, hidden = true)
    private String expenseCode;

    @Schema(title = "Project Public Id",
            description = "project public Id", maxLength = 36,
            type = "string", example = " ")
    private String projectPublicId;

    @Schema(title = "Bank Public Id",
            description = "bank public Id", maxLength = 8, hidden = true)
    private String projectCode;

    @Schema(title = "Bank Public Id",
            description = "bank public Id", maxLength = 36,
            type = "string", example = " ",
            defaultValue = "8567BC48022737BB167D6F785C31B845BDDBAFC3E36144E1152135FD93927FE5")
    private String bankApiPublicId;

    @Schema(title = "Payer User Id",
            description = "payer user public Id", maxLength = 36,
            type = "string", example = " ")
    private String payerUserPublicId;

    @Schema(title = "Payer Contact Public Id",
            description = "payer contact public Id", maxLength = 36,
            type = "string", example = " ")
    private String payerContactPublicId;

    @Schema(title = "Account Public Id",
            description = "account public Id", maxLength = 36,
            type = "string", example = " ")
    private String accountPublicId;

    @Schema(title = "Request IP",
            description = "request IP", maxLength = 16,
            type = "string", example = " ", nullable = true)
    private String requestIp;

    @Schema(title = "Request Description",
            description = "request description", maxLength = 500, nullable = true, type = "string", example = " ")
    private String requestDescription;
}
