package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.MessageReceiverDto;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodCertificateSmsApiDto implements Serializable {

    private static final long serialVersionUID = -52371190544343302L;

    private Long id;
    private String publicId;

    private RegisterDto registerDto;
    private Long registerId;
    private String registerPublicId;
    private String registerFinalStatus;
    private String registerFinancialStatus;
    private String registerType;

    private PeriodCertificateDto periodCertificateDto;
    private Long periodCertificateId;
    private String periodCertificatePublicId;
    private Long periodCertificateActivityStatus;
    private String periodCertificateDeliveryDate;

    private MessageReceiverDto messageReceiverDto;
    private Long messageReceiverId;

    private String smsText;
    private Long smsStatus;
    private Long smsCounter;
    private String smsDate;
    private String description;
    private Timestamp createDateTs;
    private Timestamp deleteDateTS;

    private String fullName;
    private String phone;
    private String fieldName;
    private String periodName;


}
