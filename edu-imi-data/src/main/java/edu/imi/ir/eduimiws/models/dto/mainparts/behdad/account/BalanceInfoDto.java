package edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BalanceInfoDto implements Serializable {

    private static final long serialVersionUID = -5584311086342397933L;
    private Long id;
    private BigDecimal credit;
    private BigDecimal monetary;
    private String reportDate;
    private BigDecimal systemBlock;
    private BigDecimal userBlock;
}
