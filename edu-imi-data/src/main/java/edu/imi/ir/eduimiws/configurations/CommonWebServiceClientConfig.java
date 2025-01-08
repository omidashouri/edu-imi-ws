package edu.imi.ir.eduimiws.configurations;


/*→1
import edu.imi.ir.eduimiws.models.behdad.account.AccountService;
import edu.imi.ir.eduimiws.models.behdad.account.Credential;*/

//import edu.imi.ir.eduimiws.models.behdad.account.BehdadAccountServiceWsdlImpl;
/*import edu.imi.ir.eduimiws.models.behdad.identifier.IdentifierService;
import edu.imi.ir.eduimiws.models.behdad.identifier.IdentifierServiceImplService;*/

import edu.imi.ir.eduimiws.models.dto.sabtahval.SabtahvalCredential;
import edu.imi.ir.eduimiws.security.BehdadCredential;
import edu.imi.ir.eduimiws.security.DigitalPaymentCredential;
import edu.imi.ir.eduimiws.services.api.reqres.SOAPConnector;
import edu.imi.ir.eduimiws.services.api.reqres.SoapClientImpl2;
import org.apache.http.Header;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.RequestDefaultHeaders;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Configuration
@PropertySources({
        @PropertySource("classpath:application-dev.properties"),
        @PropertySource("classpath:application-prod.properties"),
        @PropertySource("classpath:security.properties")
})
public class CommonWebServiceClientConfig {


    @Autowired
    DigitalPaymentCredential digitalPaymentCredential;

    @Autowired
    BehdadCredential behdadCredential;

/*    @Value("${server.ssl.trust-store}")
    private Resource trustStore;

    @Value("${server.ssl.trust-store-password}")
    private String trustStorePassword;*/

    @PostConstruct
    private void configureSSL() throws IOException {
//        URL trustStoreResource = CommonWebServiceClientConfig.class.getResource( "jks/bb.pfx" );
//        String path = trustStoreResource.toURI().getPath();
/*        String path = trustStore.getURI().getPath();
        System.setProperty("javax.net.ssl.trustStore", path);
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");*/
    }

    @Bean
    @ConfigurationProperties(prefix = "sabtahvalcredential")
    public SabtahvalCredential sabtahvalCredential() {
        return new SabtahvalCredential();
    }

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("edu.imi.ir.eduimiws.models.wsdl");
        return marshaller;
    }

    @Bean
    public SOAPConnector soapConnector(Jaxb2Marshaller jaxb2Marshaller) {
        SOAPConnector client = new SOAPConnector();
        client.setDefaultUri(digitalPaymentCredential.getBehpardakhtCredential().getUri());
        client.setMarshaller(jaxb2Marshaller);
        client.setUnmarshaller(jaxb2Marshaller);
        return client;
    }

    @Bean
    public SoapClientImpl2 mellatClient(Jaxb2Marshaller jaxb2Marshaller) {
        SoapClientImpl2 client = new SoapClientImpl2();
//        client.setDefaultUri("https://bpm.shaparak.ir/pgwchannel/services/pgw?wsdl");
        client.setDefaultUri(digitalPaymentCredential.getBehpardakhtCredential().getUri());
        client.setMarshaller(jaxb2Marshaller);
        client.setUnmarshaller(jaxb2Marshaller);
        return client;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate() throws Exception {
        final WebServiceTemplate webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller(), jaxb2Marshaller());
        webServiceTemplate.setDefaultUri(digitalPaymentCredential.getBehpardakhtCredential().getUri());
        webServiceTemplate.setMarshaller(jaxb2Marshaller());
        webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
//        webServiceTemplate.setMessageSender(messageSender());
        webServiceTemplate.setMessageSender(httpComponentsMessageSender());
        return webServiceTemplate;
    }

/*    @Bean
    public HttpsUrlConnectionMessageSender messageSender() throws Exception {
        HttpsUrlConnectionMessageSender messageSender = new HttpsUrlConnectionMessageSender();
        return messageSender;
    }*/

    @Bean
    public HttpComponentsMessageSender httpComponentsMessageSender() {
        HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
        httpComponentsMessageSender.setCredentials(usernamePasswordCredentials());
        return httpComponentsMessageSender;
    }

    @Bean
    public UsernamePasswordCredentials usernamePasswordCredentials() {
        return new UsernamePasswordCredentials(digitalPaymentCredential.getBehpardakhtCredential().getUsername(),
                digitalPaymentCredential.getBehpardakhtCredential().getPassword());
    }

/*    @Bean
    public BpPayRequest bpPayRequest(){
        return new BpPayRequest();
    }*/


/*    @Bean
    CommandLineRunner lookup(SOAPConnector soapConnector) {
        return args -> {
            String name = "Sajal";//Default Name
            if(args.length>0){
                name = args[0];
            }
            StudentDetailsRequest request = new StudentDetailsRequest();
            request.setName(name);
            StudentDetailsResponse response =(StudentDetailsResponse) soapConnector.callWebService("http://localhost:8080/service/student-details", request);
            System.out.println("Got Response As below ========= : ");

        };
    }*/


    //    SABTE AHVAL --------------------->>>>

    @Bean
    public Jaxb2Marshaller jaxb2SabtAhvalMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(sabtahvalCredential().getPackagesToScan());
        return marshaller;
    }

    private String base64authUserPassword(String username, String password) {
        String userpassword = username + ":" + password;
        String encodedAuthorization = new String(Base64.getEncoder().encode(userpassword.getBytes()));
        return encodedAuthorization;
    }

    private HttpClient httpClient(String username, String password) throws Exception {
        List<Header> headers = new ArrayList<>();
        BasicHeader authHeader = new BasicHeader("Authorization", "Basic " + base64authUserPassword(username, password));
        headers.add(authHeader);
        RequestDefaultHeaders reqHeader = new RequestDefaultHeaders(headers);
        return HttpClientBuilder.create()
                .addInterceptorFirst(new HttpComponentsMessageSender.RemoveSoapHeadersInterceptor())
                .addInterceptorLast(reqHeader).build();
    }

    private HttpComponentsMessageSender httpComponentsMessageSender(String userName, String password) throws Exception {
        HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
        httpComponentsMessageSender.setHttpClient(httpClient(userName, password));
        return httpComponentsMessageSender;
    }


    @Bean
    WebServiceTemplate webServiceTemplateSabtAhval() throws Exception {

        WebServiceTemplate wsTemplate = new WebServiceTemplate();

        wsTemplate
                .setDefaultUri(sabtahvalCredential().getUri());
//        wsTemplate.setMessageSender(defaultMyMessageSender());
        wsTemplate
                .setMessageSender(this
                        .httpComponentsMessageSender(sabtahvalCredential().getMessageSenderUsername(),
                                sabtahvalCredential().getMessageSenderPassword()));
        wsTemplate.setMarshaller(jaxb2SabtAhvalMarshaller());
        wsTemplate.setUnmarshaller(jaxb2SabtAhvalMarshaller());

        return wsTemplate;
    }

/*    @Bean
    HttpClient createHttpClient() {
        List<Header> headers = new ArrayList<>();
        BasicHeader authHeader = new BasicHeader("Authorization", "Basic " + base64authUserPassword());
        headers.add(authHeader);
        // add more header as more as needed

        RequestDefaultHeaders reqHeader = new RequestDefaultHeaders(headers);

        CloseableHttpClient httpClient =
                HttpClients.custom()
                        .addInterceptorFirst(new HttpComponentsMessageSender.RemoveSoapHeadersInterceptor())
                        .addInterceptorLast(reqHeader)
                        .build();
        return httpClient;
    }

    @Bean
    public HttpComponentsMessageSender defaultMyMessageSender()
            throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {

        HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender(createHttpClient());
        //messageSender.setCredentials(credentials());
        return messageSender;
    }*/

//   <<< ------------------------- SABTE AHVAL


//    Behdad (Bank Markazi) --------------------->>>>
/*    @Bean
    public AccountService accountServiceBehdad(){
        return new AccountServiceImplService().getAccountServiceImplPort();
    }*/

/* 1→
    @Bean
    public Jaxb2Marshaller jaxb2BehdadAccountMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(behdadCredential.getAccountPackagesToScan());
        return marshaller;
    }

    @Bean
    WebServiceTemplate webServiceTemplateBehdadAccount() throws Exception {
        WebServiceTemplate wsTemplate = new WebServiceTemplate();
        wsTemplate.setDefaultUri(behdadCredential.getAccountUri());
//        wsTemplate.setMessageSender(this.behdadAccountHttpComponentsMessageSender());
        wsTemplate.setMessageSender(this.behdadAccountHttpComponentsMessageSenderTwo());
        wsTemplate.setMarshaller(jaxb2BehdadAccountMarshaller());
        wsTemplate.setUnmarshaller(jaxb2BehdadAccountMarshaller());
        return wsTemplate;
    }

    public HttpComponentsMessageSender behdadAccountHttpComponentsMessageSender() throws Exception {
        HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
        httpComponentsMessageSender.setHttpClient(this.behdadAccountHttpClient());
        return httpComponentsMessageSender;
    }

    public HttpClient behdadAccountHttpClient() throws Exception {
        return HttpClientBuilder.create().setSSLSocketFactory(this.behdadAccountSslConnectionSocketFactory())
                .addInterceptorFirst(new HttpComponentsMessageSender.RemoveSoapHeadersInterceptor()).build();
    }

    public SSLConnectionSocketFactory behdadAccountSslConnectionSocketFactory() throws Exception {
        // NoopHostnameVerifier essentially turns hostname verification off as otherwise following error
        // is thrown: java.security.cert.CertificateException: No name matching localhost found
        return new SSLConnectionSocketFactory(this.behdadAccountSSLContext(), NoopHostnameVerifier.INSTANCE);
    }

    public SSLContext behdadAccountSSLContext() throws Exception {
        return SSLContextBuilder
                .create()
                .loadTrustMaterial(trustStore.getFile(), trustStorePassword.toCharArray()).build();
    }*/

//    second solution:



//    https://www.baeldung.com/java-trustanchors-parameter-must-be-non-empty
//    https://stackoverflow.com/questions/46794775/spring-ws-client-authentication-with-server-and-client-certificates
//todo: download and add behdad certificate from wsl to keystore → uncomment *
//todo: import imi to java certs
//todo: add keystore to the wsdl
//todo: if still error add imi keystore as keystore
//todo: remove all other open jdk 17 or 11
//todo: continue with java 11


//    → uncomment *


  /* 2→
    @Bean
    public HttpsUrlConnectionMessageSender behdadAccountHttpComponentsMessageSenderTwo() throws Exception {
//        HttpsUrlConnectionMessageSender messageSender = new BasicAuthHttpsConnectionMessageSender(username, password);
        HttpsUrlConnectionMessageSender messageSender = new HttpsUrlConnectionMessageSender();
        messageSender.setTrustManagers(this.trustManagersFactoryBean().getObject());
        messageSender.setKeyManagers(keyManagersFactoryBean().getObject());
        return messageSender;
    }

    @Bean
    public KeyManagersFactoryBean keyManagersFactoryBean() throws GeneralSecurityException, IOException {
        KeyManagersFactoryBean keyManagersFactoryBean = new KeyManagersFactoryBean();
//        keyManagersFactoryBean.setKeyStore(keyStore().getObject());
//        keyManagersFactoryBean.setPassword("Im!@1401");
        KeyStore keyStoreDefault = KeyStoreUtils.loadDefaultKeyStore();
        keyManagersFactoryBean.setKeyStore(keyStoreDefault);
        return keyManagersFactoryBean;
    }

    @Bean
    public KeyStoreFactoryBean keyStore() throws GeneralSecurityException, IOException {
        KeyStoreFactoryBean keyStoreFactoryBean = new KeyStoreFactoryBean();
        keyStoreFactoryBean.setLocation(new ClassPathResource("imi.jks"));
        keyStoreFactoryBean.setPassword("Im!@1401");
        return keyStoreFactoryBean;
    }

    @Bean
    public TrustManagersFactoryBean trustManagersFactoryBean() throws GeneralSecurityException, IOException {
        TrustManagersFactoryBean trustManagersFactoryBean = new TrustManagersFactoryBean();
//        trustManagersFactoryBean.setKeyStore(trustStore().getObject());
        KeyStore trustStoreDefaults = KeyStoreUtils.loadDefaultTrustStore();
        trustManagersFactoryBean.setKeyStore(trustStoreDefaults);
        return trustManagersFactoryBean;
    }

    @Bean
    public KeyStoreFactoryBean trustStore() {
        KeyStoreFactoryBean keyStoreFactoryBean = new KeyStoreFactoryBean();
        keyStoreFactoryBean.setLocation(new ClassPathResource(trustStore.getFilename())); // "truststore.jks" Located in src/main/resources
        keyStoreFactoryBean.setPassword(trustStorePassword);
        return keyStoreFactoryBean;
    }


    @Bean
    Credential credentialAccount(){
        Credential credentialAccount = new Credential();
        credentialAccount.setUsername(behdadCredential.getAccountUsername());
        credentialAccount.setPassword(behdadCredential.getAccountPassword());
        return credentialAccount;
    }*/

/*    @Bean
    public IdentifierService identifierServiceBehdad(){
        return new IdentifierServiceImplService().getIdentifierServiceImplPort();
    }

    @Bean
    edu.imi.ir.eduimiws.models.behdad.identifier.Credential credentialIdentifier(){
        edu.imi.ir.eduimiws.models.behdad.identifier.Credential credentialIdentifier = new edu.imi.ir.eduimiws.models.behdad.identifier.Credential();
        credentialIdentifier.setUsername(behdadCredential.getIdentifierUsername());
        credentialIdentifier.setPassword(behdadCredential.getIdentifierPassword());
        return credentialIdentifier;
    }*/

//   <<< ------------------------- Behdad (Bank Markazi)

}


