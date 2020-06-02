package edu.imi.ir.eduimiws.utilities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:security.properties")
})
public class AppProperties {

/*    private final Environment environment;

    public AppProperties(Environment environment) {
        this.environment = environment;
    }

    public String getTokenSecretEn(){
        return environment.getProperty("token.secret");
    }*/

    private static String tokenSecret;

    private static String expirationTime; //10 days

    private static String tokenPrefix;

    private static String headerString;

    private static String signUpUrl;

    private static String verificationEmailUrl;

    private static String passwordResetRequestUrl;

    private static String passwordResetUrl;

    private static String passwordResetExpirationTime;

    private static String behpardakhtAfterPaymentResponseUrl;

//    private static String h2Console;

    @Value("${token.secret}")
    public void setTokenSecret(String tokenSecret) {
        AppProperties.tokenSecret = tokenSecret;
    }

    @Value("${expiration.time}")
    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Value("${token.prefix}")
    public void setTokenPrefix(String tokenPrefix) {
        this.tokenPrefix = tokenPrefix;
    }

    @Value("${header.string}")
    public void setHeaderString(String headerString) {
        this.headerString = headerString;
    }

    @Value("${sign.up.url}")
    public void setSignUpUrl(String signUpUrl) {
        this.signUpUrl = signUpUrl;
    }

    @Value("${verification.email.url}")
    public void setVerificationEmailUrl(String verificationEmailUrl) {
        this.verificationEmailUrl = verificationEmailUrl;
    }

    @Value("${password.reset.request.url}")
    public void setPasswordResetRequestUrl(String passwordResetRequestUrl) {
        this.passwordResetRequestUrl = passwordResetRequestUrl;
    }

    @Value("${password.reset.url}")
    public void setPasswordResetUrl(String passwordResetUrl) {
        this.passwordResetUrl = passwordResetUrl;
    }

    @Value("${password.reset.expiration.time}")
    public void setPasswordResetExpirationTime(String passwordResetExpirationTime) {
        this.passwordResetExpirationTime = passwordResetExpirationTime;
    }

    @Value("behpardakht.after.payment.response.url")
    public void setBehpardakhtAfterPaymentResponseUrl(String behpardakhtAfterPaymentResponseUrl) {
        this.behpardakhtAfterPaymentResponseUrl = behpardakhtAfterPaymentResponseUrl;
    }

    public static String getTokenSecret() {
        return tokenSecret;
    }

    public static String getExpirationTime() {
        return expirationTime;
    }

    public static String getTokenPrefix() {
        return tokenPrefix;
    }

    public static String getHeaderString() {
        return headerString;
    }

    public static String getSignUpUrl() {
        return signUpUrl;
    }

    public static String getVerificationEmailUrl() {
        return verificationEmailUrl;
    }

    public static String getPasswordResetRequestUrl() {
        return passwordResetRequestUrl;
    }

    public static String getPasswordResetUrl() {
        return passwordResetUrl;
    }

    public static String getPasswordResetExpirationTime() {
        return passwordResetExpirationTime;
    }

    public static String getBehpardakhtAfterPaymentResponseUrl() {
        return behpardakhtAfterPaymentResponseUrl;
    }

/*    public static String getH2Console() {
        return h2Console;
    }*/

/*    @Value("${h2.console}")
    public void setH2Console(String h2Console) {
        AppProperties.h2Console = h2Console;
    }*/

    /*    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }*/
}
