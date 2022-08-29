package edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account;

import lombok.*;

import java.io.Serializable;
import java.util.List;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MultipleAccountTransactionFilterDto implements Serializable {

    private static final long serialVersionUID = -5637017190247030244L;
    private Long id;
    private List<String> accountNumbers;
    private String fromDateTime;
    private String paymentIdentifier;
    private String toDateTime;
}
