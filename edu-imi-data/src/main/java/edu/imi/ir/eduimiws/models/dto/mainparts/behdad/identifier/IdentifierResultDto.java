package edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier;


import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdentifierResultDto {

    private BigDecimal amount;
    private String description;
    private String identifier;
    private boolean result;
}
