package edu.imi.ir.eduimiws.services.api.reqres;



import edu.imi.ir.eduimiws.models.wsdl.mellat.BpPayRequest;
import edu.imi.ir.eduimiws.models.wsdl.mellat.BpPayRequestResponse;
import edu.imi.ir.eduimiws.models.wsdl.mellat.ObjectFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.bind.JAXBElement;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class SoapClientImpl {

    private final WebServiceTemplate webServiceTemplate;
    @Qualifier("jaxb2Marshaller") private final Jaxb2Marshaller jaxb2Marshaller;

//    ConfRegisterConfirmStartAction

    public String callMellat(){

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);

            BpPayRequest bpPayRequest = new BpPayRequest();
            bpPayRequest.setCallBackUrl("http://www.imi.ir/Pages/home.aspx");
            bpPayRequest.setAmount(1000);
//        MAINPARTS.SEQ_RESERVATION_NUMBER
            bpPayRequest.setOrderId(123456789l);
            bpPayRequest.setLocalDate("20200531");
            bpPayRequest.setLocalTime("134251");
            bpPayRequest.setAdditionalData("for test 1");
            bpPayRequest.setTerminalId(818149l);
            bpPayRequest.setUserName("erpimi");
            bpPayRequest.setUserPassword("58975627");

            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            WebServiceTemplate springWSTemplate = context.getBean(WebServiceTemplate.class);
//        PaymentGatewayImplService paymentGatewayImplService = new PaymentGatewayImplService();

//      OR 1 >>>

        JAXBElement<BpPayRequestResponse> jaxbResponse = (JAXBElement<BpPayRequestResponse>) webServiceTemplate
                .marshalSendAndReceive("https://bpm.shaparak.ir/pgwchannel/services/pgw?wsdl",
                new ObjectFactory().createBpPayRequest(bpPayRequest));

        BpPayRequestResponse bpPayRequestResponse = jaxbResponse.getValue();

//        http://interfaces.core.sw.bps.com
       Object oo =  webServiceTemplate
               .marshalSendAndReceive("https://bpm.shaparak.ir/pgwchannel/services/pgw?wsdl",bpPayRequest);

//        jaxbMarshaller.marshal(new JAXBElement<VSM>(new QName("uri","local"), VSM.class, vsm), System.out);

        return "yes";
    }
}


/*  1 >>>

        edu.imi.ir.eduimiws.models.wsdl.ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<BpPayRequest> bpPayRequestJAXBElement = objectFactory
                                                                .createBpPayRequest(bpPayRequest);

        JAXBElement<BpPayRequestResponse> bpPayRequestResponseJAXBElement = objectFactory
                                                    .createBpPayRequestResponse(new BpPayRequestResponse());

        Object marshalSendAndReceive = webServiceTemplate
                    .marshalSendAndReceive("https://bpm.shaparak.ir/pgwchannel/services/pgw?wsdl",
                                                                                bpPayRequestJAXBElement);
        bpPayRequestResponseJAXBElement = (JAXBElement<BpPayRequestResponse>) marshalSendAndReceive;

 */