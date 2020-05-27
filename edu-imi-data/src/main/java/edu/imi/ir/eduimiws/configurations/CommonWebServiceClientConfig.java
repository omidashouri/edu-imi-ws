package edu.imi.ir.eduimiws.configurations;

/*@PropertySource("classpath:wsdl.properties")
@ConfigurationProperties(prefix = "wsdl")*/
/*
@Configuration
public class CommonWebServiceClientConfig {


    @Value("${wsdl.sabteahval.uri}")
    private String sabteahvalUri;

    @Value("${wsdl.sabteahval.username}")
    private String sabteahvalUsername;

    @Value("${wsdl.sabteahval.password}")
    private String sabteahvalPassword;


    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setPackagesToScan("ed");
        marshaller.setContextPath("edu.imi.ir.eduimiws.models.wsdl");
        return marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate() throws Exception {
        final WebServiceTemplate webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller(), jaxb2Marshaller());
        webServiceTemplate.setDefaultUri(sabteahvalUri);
        webServiceTemplate.setMarshaller(jaxb2Marshaller());
        webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
        webServiceTemplate.setMessageSender(messageSender());
//        webServiceTemplate.setMessageSender(httpComponentsMessageSender());
        return webServiceTemplate;
    }

    @Bean
    public HttpsUrlConnectionMessageSender messageSender() throws Exception {
        HttpsUrlConnectionMessageSender messageSender = new HttpsUrlConnectionMessageSender();
        return messageSender;
    }

    @Bean
    public HttpComponentsMessageSender httpComponentsMessageSender() {
        HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
        httpComponentsMessageSender.setCredentials(usernamePasswordCredentials());
        return httpComponentsMessageSender;
    }

    @Bean
    public UsernamePasswordCredentials usernamePasswordCredentials() {

        return new UsernamePasswordCredentials(sabteahvalUsername, sabteahvalPassword);
    }
}
*/

