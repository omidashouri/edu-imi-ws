package edu.imi.ir.eduimiws.models.dto.hamkaran;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HamkaranAuthenticationTokenDto implements Serializable {

    private static final long serialVersionUID = 6338909568226599475L;

    private String code;
    private String success;
    private String token;
    private String message;

}
