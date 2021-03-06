package edu.imi.ir.eduimiws.models.dto.mainparts;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefundApiDto implements Serializable {

    private static final long serialVersionUID = -2584570345905350497L;

    private Long id;

    private RefundDto refundDto;
    private Long refundId;

    private String refundPublicId;

    private Timestamp createDateTs;

    private Long deletedRefundId;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;
}
