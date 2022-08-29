package edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SideTransactionsRequestDto implements Serializable {

    private Long id;
    private String accountNumber;
    private long transactionId;
}
