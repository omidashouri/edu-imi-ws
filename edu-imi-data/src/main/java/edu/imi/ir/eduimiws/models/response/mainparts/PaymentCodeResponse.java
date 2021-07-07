package edu.imi.ir.eduimiws.models.response.mainparts;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.sql.Timestamp;

@Schema(name = "paymentCodes", description = "Class representing a payment code in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "paymentCode")
@Relation(collectionRelation = "paymentCodes")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCodeResponse extends RepresentationModel<PaymentCodeResponse> {


    private String paymentCode;

    private String paymentCodePublicId;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;

    private Long requestId;

    private String creatorPublicId;

    private String description;

    private String requestIp;

    private String requestDescription;

    private String nationalCode;

    private String expenseCodePublicId;

    private Long expenseCode;

    private String projectPublicId;

    private String projectCode;

    private Long bankId;

    private String bankCode;

    private Long requestCode;

    private String personPublicId;

    private String contactPublicId;
}
