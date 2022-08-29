package edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IsVerhoeffRequestDto implements Serializable {

    private Long id;
    private BigDecimal amount;
    private String identifierCode;
}
