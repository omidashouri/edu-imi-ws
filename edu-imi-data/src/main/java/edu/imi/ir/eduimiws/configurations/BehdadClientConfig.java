package edu.imi.ir.eduimiws.configurations;
import edu.imi.ir.eduimiws.models.wsdl.behdad.AccountService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.SSLContext;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore;
@Configuration
public class BehdadClientConfig {

    public static void configureClientCertificate(Object servicePort) throws Exception {
        Client client = ClientProxy.getClient(servicePort);
        HTTPConduit httpConduit = (HTTPConduit) client.getConduit();


        KeyStore keyStore = KeyStore.getInstance("PKCS12");
//        FileInputStream keyStoreStream = new FileInputStream("path/to/client-certificate.pfx");
        Path path  = Paths.get(ResourceLoader.class.getClassLoader().getResource("pfx/behdadcer.pfx").toURI().getPath());
        InputStream keyStoreStream = Files.newInputStream(path);

        if (keyStoreStream == null) {
            throw new RuntimeException("Keystore file not found in resources");
        }

        keyStore.load(keyStoreStream, "Im!@0075175266".toCharArray());

        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, "Im!@0075175266".toCharArray());

        // Load truststore (optional, to trust server certificate)
/*        KeyStore trustStore = KeyStore.getInstance("JKS");
        FileInputStream trustStoreStream = new FileInputStream("path/to/truststore.jks");
        trustStore.load(trustStoreStream, "truststore_password".toCharArray());
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustStore);*/

        // Set TLS parameters
        TLSClientParameters tlsParams = new TLSClientParameters();
        tlsParams.setKeyManagers(kmf.getKeyManagers());
//        tlsParams.setTrustManagers(tmf.getTrustManagers());

        // You can disable CN check if needed (not recommended for prod)
        tlsParams.setDisableCNCheck(true);
        httpConduit.setTlsClientParameters(tlsParams);
    }


    public static AccountService createAccountServiceProxy() throws Exception {
        // Step 1: Initialize ProxyFactoryBean
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

        // Step 2: Set the service WSDL URL
        factory.setAddress("https://behdadservices.cbinasim.ir:5050/behdad-account/v2/accountservice");

        // Step 3: Set the service interface (AccountService)
        factory.setServiceClass(AccountService.class);

        // Step 4: Create the proxy
        AccountService accountService = (AccountService) factory.create();

        // Step 5: Apply SSL configuration
        Client client = ClientProxy.getClient(accountService);
        HTTPConduit httpConduit = (HTTPConduit) client.getConduit();

        // Configure the client certificate
        KeyStore keyStore = KeyStore.getInstance("PKCS12","BC");
        InputStream keyStoreStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("pfx/behdadcer.pfx");
        if (keyStoreStream == null) {
            throw new RuntimeException("Keystore file not found");
        }

        keyStore.load(keyStoreStream, "Im!@0075175266".toCharArray());

        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, "Im!@0075175266".toCharArray());

        // Set TLS parameters
        TLSClientParameters tlsParams = new TLSClientParameters();
        tlsParams.setKeyManagers(kmf.getKeyManagers());

        // Optionally configure the truststore
        // tlsParams.setTrustManagers(tmf.getTrustManagers());

        httpConduit.setTlsClientParameters(tlsParams);

        return accountService;
    }

}
