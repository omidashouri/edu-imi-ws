package edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier;

import lombok.*;

import java.math.BigDecimal;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdentifierDetailDto {

    private String accountNumber;
    private boolean active;
    private BigDecimal amount;
    private String endDate;
    private String identifier;
    private String lastUpdate;
    private String startDate;
}
