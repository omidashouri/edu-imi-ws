package edu.imi.ir.eduimiws.models.response.mainparts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.sql.Timestamp;

@Schema(name = "paymentCodeResponseDescriptive", description = "Class representing a payment code descriptive in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "paymentCodeResponseDescriptive")
@Relation(collectionRelation = "paymentCodeResponseDescriptives")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCodeResponseDescriptive extends RepresentationModel<PaymentCodeResponseDescriptive> {


    @Schema(title = "Payment Code", maxLength=17)
    private String paymentCode;

    @Schema(title = "Payment Code Public ID",maxLength = 36)
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

    private String expenseTitle;

    private String projectPublicId;

    private String projectCode;

    private String projectName;

    private String bankApiPublicId;

    private Long requestCode;

    private String payerUserPublicId;

    private String payerContactPublicId;

    private String payerContactMobilePhone;

    private String payerContactFullName;

    private String economicalCode;

    private String accountName;
}
