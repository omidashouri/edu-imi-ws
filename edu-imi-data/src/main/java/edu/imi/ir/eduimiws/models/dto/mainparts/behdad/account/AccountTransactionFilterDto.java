package edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransactionFilterDto implements Serializable {

    private static final long serialVersionUID = 683585229721223290L;
    private Long id;
    private String accountNumber;
    private String fromDateTime;
    private String paymentIdentifier;
    private String toDateTime;
}
