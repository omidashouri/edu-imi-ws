package edu.imi.ir.eduimiws.models.dto.mainparts;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MelliVerifyDto implements Serializable {


    private Long id;

    private String publicId;

    private String token;

    private String signData;

    private Long succeed;

    private String resCode;

    private String description;

    private String amount;

    private String retrivalRefNo;

    private String systemTraceNo;

    private String orderId;

    private String terminalId;

    private Long creatorId;

    private Timestamp createDateTs;

    private Timestamp deleteDateTs;

    private Long merchantOrderId;

    private Long melliDigitalPaymentId;

    private String melliDigitalPaymentPublicId;
}
