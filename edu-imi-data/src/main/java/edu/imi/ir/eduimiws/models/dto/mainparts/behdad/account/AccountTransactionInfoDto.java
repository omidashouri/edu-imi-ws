package edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransactionInfoDto implements Serializable {

    private static final long serialVersionUID = 62431004032131141L;
    private Long id;
    private String accountNumber;
    private BigDecimal amount;
    private long transactionId;
    private String transactionIdentifier;
}
