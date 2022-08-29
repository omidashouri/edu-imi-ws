package edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier;

import lombok.*;

import java.math.BigDecimal;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdentifierInfoDto {

    private Long id;
    private String accountNumber;
    private BigDecimal amount;
    private String identifier;
    private String toDate;
}
