package edu.imi.ir.eduimiws.models.dto.mainparts.behdad;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CredentialDto implements Serializable {

    private static final long serialVersionUID = 1435207849543189394L;
    private Long id;
    private String password;
    private String username;
}
