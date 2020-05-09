package edu.imi.ir.eduimiws.configurations;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@PropertySource("classpath:mail.properties")
@ConfigurationProperties(prefix = "spring.mail")
@Validated
public class MailProperties {


    @NotNull
    private String protocol;

    @NotNull
    private Charset defaultEncoding;

    @NotNull
    private String host;

    @NotNull
    private Integer port;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private boolean auth;

    @NotNull
    private String from;

    private Map<String, String> properties = new HashMap<>();



}
