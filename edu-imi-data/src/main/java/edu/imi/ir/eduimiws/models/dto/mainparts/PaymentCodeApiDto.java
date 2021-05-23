package edu.imi.ir.eduimiws.models.dto.mainparts;

import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCodeApiDto implements Serializable {


    private static final long serialVersionUID = -8837872266418737749L;

    private Long id;

    private String paymentCodePublicId;

    private String paymentCode;

    private Timestamp createDateTs;

    private Timestamp editDateTs;

    private Timestamp deleteDateTs;

    private Long requestId;

    private PersonDto creator;
    private String creatorPublicId;
    private Long creatorId;

    private String description;

    private String requestIp;

    private String requestDescription;
}
