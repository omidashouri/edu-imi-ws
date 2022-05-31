package edu.imi.ir.eduimiws.security;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FarapayamakCredential {

    private String username;
    private String password;
    private String sendNumberOne;
    private String sendNumberTwo;
    private String sendNumberThree;
    private String sendSmsUrl;
}
