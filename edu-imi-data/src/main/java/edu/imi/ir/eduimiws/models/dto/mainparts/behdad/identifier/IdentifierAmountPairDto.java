package edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier;

import lombok.*;

import java.math.BigDecimal;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdentifierAmountPairDto {

    private BigDecimal amount;
    private String identifier;
}
