package edu.imi.ir.eduimiws.utilities;

//import edu.imi.ir.eduimiws.models.behdad.account.*;
//import edu.imi.ir.eduimiws.models.behdad.account.*;

import edu.imi.ir.eduimiws.services.mainparts.BehdadAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BehdadServiceTest {


/*1    @Autowired
    @Qualifier("jaxb2BehdadAccountMarshaller")
    Jaxb2Marshaller jaxb2BehdadAccountMarshaller;*/


    @Autowired
    BehdadAccountService behdadAccountService;

    @Autowired
//    AccountService accountService;



//    todo: need xsd, try to solve by other way
//    todo:
//     1- get generate classes in two separate package otherwise object factory is override
//     2- create Object factory for each package by different name (like Qualifier)
//    3- pay attention to uri with method name called in service(  test http://service.account.behdad.bis.misc.com/}BehdadAccountServiceWsdlImpl)


    @Test
    void testAccountNumber(){

       /* JAXBElement<HandShake> request = new ObjectFactory<>().
        logger.info(String.format("request: {0}", "handshake request"));
        logger.debug("sending request");
        HandShakeResponse handShakeResponse = ((JAXBElement<HandShakeResponse>) getWebServiceTemplate()
                .marshalSendAndReceive(request, new SoapActionCallback(
                        "urn:handShake"))).getValue();*/

/*        (JAXBElement<BpPayRequestResponse>) webServiceTemplate
                .marshalSendAndReceive("https://bpm.shaparak.ir/pgwchannel/services/pgw?wsdl",
                        new edu.imi.ir.eduimiws.models.wsdl.ObjectFactory().createBpPayRequest(bpPayRequest));*/

/*2        GetAccountNumbers getAccountNumbers = new GetAccountNumbers();

        Credential credential = new Credential();
        credential.setUsername("654987");
        credential.setPassword("Pdr@102030");
        getAccountNumbers.setArg0(credential);*/

//        Object response =(JAXBElement<GetAccountNumbersResponse>) webServiceTemplateBehdadAccount.marshalSendAndReceive(new ObjectFactory().createGetAccountNumbers(getAccountNumbers));

//3        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(jaxb2BehdadAccountMarshaller);
/*
        JAXBElement<GetAccountNumbersResponse> response =(JAXBElement<GetAccountNumbersResponse>) webServiceTemplate
                .marshalSendAndReceive("http://172.31.55.13:8443/behdad/accountservice?wsdl",
                        new ObjectFactory().createGetAccountNumbers(getAccountNumbers));
*/

/*4       Service accountService = new BehdadAccountServiceWsdlImpl();
        AccountService accountService1 = ((BehdadAccountServiceWsdlImpl) accountService).getAccountServiceImplPort();*/
//5        try {
/*            ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
            changePasswordRequest.setUsername("imi");
            changePasswordRequest.setPassword("V@ffM-4%");
            changePasswordRequest.setNewPassword("Imi@0075175266");
            accountService1.changePassword(changePasswordRequest); *///invalidCredentialException
//6            accountService1.getAccountNumbers(credential); //PasswordIsNotStrongException

            behdadAccountService.getAccountNumbers();


/*7        } catch (InvalidCredentialException_Exception e) {
            e.printStackTrace();
        } catch (UnableToAuthenticateException_Exception e) {
            e.printStackTrace();
        } catch (PasswordIsNotStrongException_Exception e) {
            e.printStackTrace();
        } catch (UserTemporarilySuspendedException_Exception e) {
            e.printStackTrace();
        }*/

//        System.out.println(response);
        System.out.println("salam");
    }


/*    @Test
    void testNewAccountNumber() throws InvalidCredentialException_Exception, UnableToGetClientCertificateInfo_Exception, UserTemporarilySuspendedException_Exception, UnableToAuthenticateException_Exception, InvalidCertificateException_Exception, PasswordIsNotStrongException_Exception, ExpiredOrNotValidCertificateException_Exception, PasswordShouldBeChangeException_Exception {
        final BalanceInfo accountBalance = accountService.getAccountBalance(null, null);
        System.out.println("finished");
    }*/
}
