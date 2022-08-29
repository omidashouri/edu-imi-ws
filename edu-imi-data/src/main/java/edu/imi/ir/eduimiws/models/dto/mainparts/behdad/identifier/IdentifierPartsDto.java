package edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdentifierPartsDto {

    private String baseCode;
    private String identifierPrefix;
    private String incomeIndexCode;
    private String incomeSubsidiaryCode;
    private String organCustomCode;
}
