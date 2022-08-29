package edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenerateIdentifierByOrganRequestDto {

    protected BigDecimal amount;
    protected IdentifierPartsDto identifierPartsDto;
}
