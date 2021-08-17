package edu.imi.ir.eduimiws.security;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mellicredential")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MelliCredential {

    private String merchantId;

    private String terminalId;

    private String encryptionKey;

    private String unicodeFormat;

    private String dataEncryptionStandardAlgorithm;

    private String encryptionAlgorithm;

    private String gatewayUrl;

    private String ipgUriGetToken;

    private String ipgUriPayment;

    private String ipgUriVerifyTransaction;

}
