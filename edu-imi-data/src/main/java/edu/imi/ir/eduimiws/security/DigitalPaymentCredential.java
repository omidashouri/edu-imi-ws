package edu.imi.ir.eduimiws.security;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DigitalPaymentCredential {

    private BehpardakhtCredential behpardakhtCredential;

    private String melliTwoDigitCode;

    private String melliPublicId;

    private String expenseCodeDefaultPublicId;

}
