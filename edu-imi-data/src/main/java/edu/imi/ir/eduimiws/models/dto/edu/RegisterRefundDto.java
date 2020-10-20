package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.RefundDto;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRefundDto implements Serializable {

    private static final long serialVersionUID = -3700275501991408342L;

    private Long id;

    private RegisterDto registerDto;
    private Long registerId;
    private String registerPublicId;

    private Long returnFee;

    private Long returnPercent;

    private String createDate;

    private PersonDto creatorDto;
    private Long creatorId;
    private String creatorPublicId;

    private String editDate;

    private PersonDto editorDto;
    private Long editorId;
    private String editorPublicId;

    private String description;

    private Long paymentStatus;

    private Long reduceFee;

    private Long reducePercent;

    private String cancelDate;

    private String cancelType;

    private RefundDto refundDto;
    private Long refundId;
    private String refundPublicId;

    private RegisterRefundApiDto registerRefundApiDto;
    private Long registerRefundApiId;
    private String registerRefundPublicId;
}
