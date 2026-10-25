package edu.imi.ir.eduimiws.configurations;

import edu.imi.ir.eduimiws.models.helper.DefaultValues;
import edu.imi.ir.eduimiws.security.ApiUrlSecurityCredential;
import edu.imi.ir.eduimiws.security.AuthenticationCredential;
import edu.imi.ir.eduimiws.security.DigitalPaymentCredential;
import edu.imi.ir.eduimiws.security.FarapayamakCredential;
import edu.imi.ir.eduimiws.utilities.ClobHelper;
import edu.imi.ir.eduimiws.utilities.ErpPasswordEncoder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.integration.support.json.JacksonJsonObjectMapper;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.json.JsonMapper;

import java.util.Map;
import java.util.Properties;

@Configuration
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource("classpath:security.properties")
})
public class AppConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ErpPasswordEncoder erpPasswordEncoder() {
        return new ErpPasswordEncoder();
    }

    @Bean
    public SpringApplicationContext springApplicationContext() {
        return new SpringApplicationContext();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public SimpleMailMessage simpleMailMessage() {
        return new SimpleMailMessage();
    }

    @Bean
    public JacksonJsonObjectMapper jacksonJsonObjectMapper(JsonMapper jsonMapper) {
        return new JacksonJsonObjectMapper(jsonMapper);
    }

    @Bean
    @ConditionalOnMissingBean(JavaMailSender.class)
    JavaMailSenderImpl mailSender(MailProperties properties) {
        JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
        applyProperties(properties, javaMailSenderImpl);
        return javaMailSenderImpl;
    }

    @Bean
    public ClobHelper clobHelper() {
        return new ClobHelper();
    }

    private void applyProperties(MailProperties properties, JavaMailSenderImpl sender) {
        sender.setHost(properties.getHost());
        sender.setPort(properties.getPort());
        sender.setUsername(properties.getUsername());
        sender.setPassword(properties.getPassword());
        sender.setProtocol(properties.getProtocol());
        sender.setDefaultEncoding(properties.getDefaultEncoding().displayName());

        if (!properties.getProperties().isEmpty()) {
            sender.setJavaMailProperties(asProperties(properties.getProperties()));
        }
    }

    private Properties asProperties(Map<String, String> source) {
        Properties properties = new Properties();
        properties.putAll(source);
        return properties;
    }

    @Bean
    @ConfigurationProperties(prefix = "authenticationcredential")
    public AuthenticationCredential authenticationCredential() {
        return new AuthenticationCredential();
    }

    @Bean
    @ConfigurationProperties(prefix = "apiurlsecuritycredential")
    public ApiUrlSecurityCredential apiUrlSecurityCredential() {
        return new ApiUrlSecurityCredential();
    }

    @Bean
    @ConfigurationProperties(prefix = "digitalpaymentcredential")
    public DigitalPaymentCredential digitalPayMentCredential() {
        return new DigitalPaymentCredential();
    }

    @Bean
    @ConfigurationProperties(prefix = "defaultvalues")
    public DefaultValues defaultValues() {
        return new DefaultValues();
    }

    @Bean
    @ConfigurationProperties(prefix = "farapayamakcredential")
    public FarapayamakCredential farapayamakCredential() {
        return new FarapayamakCredential();
    }

}
