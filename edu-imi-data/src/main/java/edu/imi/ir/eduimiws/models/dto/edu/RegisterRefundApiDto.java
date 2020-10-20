package edu.imi.ir.eduimiws.models.dto.edu;

import edu.imi.ir.eduimiws.models.dto.mainparts.RefundDto;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRefundApiDto implements Serializable {

    private static final long serialVersionUID = 4830673127297784858L;

    private Long id;

    private RegisterRefundDto registerRefundDto;
    private Long registerRefundId;

    private String registerRefundPublicId;

    private Long deletedRegisterRefundId;

    private RegisterDto registerDto;
    private Long registerId;

    private String registerPublicId;

    private RefundDto refundDto;
    private Long refundId;

    private String refundPublicId;

    private Timestamp createDateTs;

    private Timestamp deleteDateTs;

    private Timestamp editDateTs;
}
