package edu.imi.ir.eduimiws.models.dto.mainparts;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MelliDigitalPaymentDto implements Serializable {

    private Long id;

    private Long orderId;

    private Long requestOrderId;

    private String localDateTime;

    private String returnUrl;

    private String signData;

    private String additionalData;

    private Long multiplexingDataId;

    private String userId;

    private String applicationName;

    private Long panAuthenticationType;

    private String nationalCode;

    private String cardHolderIdentity;

    private Long resCode;

    private String token;

    private String description;

    private Long creatorId;

    private Timestamp createDateTs;

    private String publicId;

    private Timestamp deleteDateTs;
}
