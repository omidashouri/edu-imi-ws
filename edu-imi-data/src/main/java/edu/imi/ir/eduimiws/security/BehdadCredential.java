package edu.imi.ir.eduimiws.security;


import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:security.properties")
})
@ConfigurationProperties(prefix = "behdadcredential")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BehdadCredential {

    private String accountUsername;
    private String accountPassword;
    private String identifierUsername;
    private String identifierPassword;
    private String accountPackagesToScan;
    private String accountUri;
}
