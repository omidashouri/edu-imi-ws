package edu.imi.ir.eduimiws.configurations;

/*@PropertySource("classpath:wsdl.properties")
@ConfigurationProperties(prefix = "wsdl")*/

import edu.imi.ir.eduimiws.services.api.reqres.SOAPConnector;
import edu.imi.ir.eduimiws.services.api.reqres.SoapClientImpl2;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@Configuration
public class CommonWebServiceClientConfig {


    @Value("${wsdl.sabteahval.uri}")
    private String sabteahvalUri;

    @Value("${wsdl.bankmellat.uri}")
    private String bankMellatUri;

    @Value("${wsdl.sabteahval.username}")
    private String sabteahvalUsername;

    @Value("${wsdl.bankmellat.username}")
    private String bankMellatUsername;

    @Value("${wsdl.sabteahval.password}")
    private String sabteahvalPassword;

    @Value("${wsdl.bankmellat.password}")
    private String bankMellatPassword;


    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("edu.imi.ir.eduimiws.models.wsdl");
//        marshaller.setContextPath("edu.imi.ir.eduimiws.models.wsdl");
        return marshaller;
    }

    @Bean
    public SOAPConnector soapConnector(Jaxb2Marshaller marshaller) {
        SOAPConnector client = new SOAPConnector();
        client.setDefaultUri(bankMellatUri);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public SoapClientImpl2 mellatClient(Jaxb2Marshaller marshaller) {
        SoapClientImpl2 client = new SoapClientImpl2();
        client.setDefaultUri("https://bpm.shaparak.ir/pgwchannel/services/pgw?wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate() throws Exception {
        final WebServiceTemplate webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller(), jaxb2Marshaller());
        webServiceTemplate.setDefaultUri(bankMellatUri);
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
        return new UsernamePasswordCredentials(bankMellatUsername, bankMellatPassword);
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

}


