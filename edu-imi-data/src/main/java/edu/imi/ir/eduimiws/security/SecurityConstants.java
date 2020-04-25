package edu.imi.ir.eduimiws.security;

import edu.imi.ir.eduimiws.configurations.AppProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SecurityConstants {

    public static final long EXPIRATION_TIME = 864000000; //10 days
    public static final long PASSWORD_RESET_EXPIRATION_TIME = 3600000; // 1 hour
    public  static final String TOKEN_PREFIX = "IMI ";
    public static final String HEADER_STRING = "authorization";
    public static final String SIGN_UP_URL = "/v1/users/register";
    public static final String VERIFICATION_EMAIL_URL = "/v1/users/email-verification";
    public static final String PASSWORD_RESET_REQUEST_URL = "/v1/users/password-reset-request";
    public static final String PASSWORD_RESET_URL = "/v1/users/password-reset";
    public static final String H2_CONSOLE = "/h2-console/**"; //h2 in memory database
//    public static final String TOKEN_SECRET = "jf9i4jgu83nfl0jfu57ejf7";

    public static String getTokenSecret(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppProperties.class);
        var appProperties =  ctx.getBean(AppProperties.class);
        return appProperties.getTokenSecretEn();
    }
}
