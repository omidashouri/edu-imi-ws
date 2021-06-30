package edu.imi.ir.eduimiws.security;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiUrlSecurityCredential {

    private String signUpUrl;
    private String verificationEmailUrl;
    private String passwordResetRequestUrl;
    private String passwordResetUrl;
    private String ipRanges;
    private String swaggerUiAntMatchers;

}
