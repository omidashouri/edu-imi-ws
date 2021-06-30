package edu.imi.ir.eduimiws.security;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationCredential {

    private String expirationTime;
    private String tokenPrefix;
    private String headerString;
    private String tokenSecret;
    private String passwordResetExpirationTime;
}
