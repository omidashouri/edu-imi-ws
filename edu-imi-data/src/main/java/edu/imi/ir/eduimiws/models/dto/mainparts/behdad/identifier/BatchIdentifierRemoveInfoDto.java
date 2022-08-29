package edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BatchIdentifierRemoveInfoDto {

    private String accountNumber;
    private List<String> identifierCodeListDto = new ArrayList<>();
}
