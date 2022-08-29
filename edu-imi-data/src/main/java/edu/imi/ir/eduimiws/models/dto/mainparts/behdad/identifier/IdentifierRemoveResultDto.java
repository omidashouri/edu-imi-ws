package edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdentifierRemoveResultDto {

    private String description;
    private String identifier;
    private boolean result;
}
