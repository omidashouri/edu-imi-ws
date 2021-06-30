package edu.imi.ir.eduimiws.security;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BehpardakhtCredential {

    private String afterPaymentResponseUrl;
    private String uri;
    private String username;
    private String password;
    private String clientDefaultUri;
}
