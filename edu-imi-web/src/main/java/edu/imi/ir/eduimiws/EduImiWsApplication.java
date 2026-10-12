package edu.imi.ir.eduimiws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EduImiWsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduImiWsApplication.class, args);
/*        System.setProperty("javax.net.ssl.trustStore", "jks/ks.keystore");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");*/
    }

}
