package edu.imi.ir.eduimiws.models.dto.mainparts.behdad;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordRequestDto implements Serializable {

    private static final long serialVersionUID = 6909792898212482478L;

    private Long id;
    private String newPassword;
    private String password;
    private String username;
}
