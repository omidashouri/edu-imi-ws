package edu.imi.ir.eduimiws.models.response.mainparts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import edu.imi.ir.eduimiws.models.response.v2.BaseResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.hateoas.server.core.Relation;

import java.sql.Timestamp;

@Schema(name = "paymentCodeCreate", description = "Payment code create response (logged POST)")
@JsonRootName(value = "paymentCode")
@Relation(collectionRelation = "paymentCodes")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class PaymentCodeCreateResponse extends BaseResponseDto {

    @Schema(title = "Payment Code", maxLength = 17)
    private String paymentCode;

    @Schema(title = "Payment Code Public ID", maxLength = 36)
    private String paymentCodePublicId;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;

    private String creatorPublicId;

    private String description;

    private String requestIp;

    private String requestDescription;

    private String nationalCode;

    private String expenseCodePublicId;

    private Long expenseCode;

    private String projectPublicId;

    private String projectCode;

    private String bankApiPublicId;

    private Long requestCode;

    private String payerUserPublicId;

    private String payerContactPublicId;

    private String accountPublicId;
}
