package edu.imi.ir.eduimiws.configurations;


import edu.imi.ir.eduimiws.models.dto.sabtahval.SabtahvalCredential;
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
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Configuration
@PropertySources({
        @PropertySource("classpath:security.properties")
})
public class CommonWebServiceClientConfig {


    @Autowired
    DigitalPaymentCredential digitalPaymentCredential;

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

}


