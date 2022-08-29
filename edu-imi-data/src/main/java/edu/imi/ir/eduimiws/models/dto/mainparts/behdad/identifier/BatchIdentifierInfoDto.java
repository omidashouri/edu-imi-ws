package edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BatchIdentifierInfoDto {

    private String accountNumber;
    private List<IdentifierAmountPairDto> identifierAmountPairDtos = new ArrayList<>();
    private String toDate;
}
