package edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountControlCreateModelDto implements Serializable {

    private Long id;
    private String accountNumber;
    private String controlType;
    private String identifierType;
    private String toDate;
}
