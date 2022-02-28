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
@ConfigurationProperties(prefix = "hamkarancredential")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HamkaranCredential {

    private String code;

    private String token;

    private String gatewayUrl;

    private String apiUriGetToken;

    private String apiUriGetFinancial;

    private String apiUriGetDeletedFinancial;

}
