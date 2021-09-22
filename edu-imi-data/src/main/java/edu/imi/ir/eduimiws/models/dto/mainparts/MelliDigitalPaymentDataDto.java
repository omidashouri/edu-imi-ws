package edu.imi.ir.eduimiws.models.dto.mainparts;


import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MelliDigitalPaymentDataDto implements Serializable {

    private Long id;

    private String publicId;

    private String orderId;

    private String hashedCardNumber;

    private String primaryAccNo;

    private String switchResCode;

    private String resCode;

    private String token;

    private String requestVerificationToken;

    private String isWalletPayment;

    private Long creatorId;

    private Timestamp createDateTs;

    private Timestamp deleteDateTs;

    private Long merchantOrderId;

    private Long melliDigitalPaymentId;

    private String melliDigitalPaymentPublicId;
}
