package edu.imi.ir.eduimiws.services.api.reqres;


import edu.imi.ir.eduimiws.models.wsdl.mellat.BpPayRequest;
import edu.imi.ir.eduimiws.models.wsdl.mellat.BpPayRequestResponse;
import edu.imi.ir.eduimiws.models.wsdl.mellat.IPaymentGateway;
import edu.imi.ir.eduimiws.models.wsdl.mellat.ObjectFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;


//IPaymentGateway is implemented by me, so any changes in the bank api should be affected here again
public class SoapClientImpl2 extends WebServiceGatewaySupport implements IPaymentGateway {
    @Override
    public String bpRefundRequest(long terminalId, String userName, String userPassword, long orderId, long saleOrderId, long saleReferenceId, long refundAmount) {
        return null;
    }

    @Override
    public String bpSaleReferenceIdRequest(long terminalId, String userName, String userPassword, long orderId, long saleOrderId) {
        return null;
    }

    @Override
    public String bpRefundToPANRequestV2(String user, String password, Long pan, long amount, Long saleReferenceId, long terminalId, long orderId, String mobileNo) {
        return null;
    }

    @Override
    public String bpDynamicPayRequest(long terminalId, String userName, String userPassword, long orderId, long amount, String localDate, String localTime, String additionalData, String callBackUrl, String payerId, long subServiceId, String mobileNo, String encPan, String panHiddenMode, String cartItem, String enc) {
        return null;
    }

/*    @Override
    public String bpDynamicPayRequest(long terminalId, String userName, String userPassword, long orderId, long amount, String localDate, String localTime, String additionalData, String callBackUrl, String payerId, long subServiceId) {
        return null;
    }*/

    @Override
    public String bpInquiryRequest(long terminalId, String userName, String userPassword, long orderId, long saleOrderId, long saleReferenceId) {
        return null;
    }

    @Override
    public String bpSettleRequest(long terminalId, String userName, String userPassword, long orderId, long saleOrderId, long saleReferenceId) {
        return null;
    }

    @Override
    public String bpVerifySettleRequest(long terminalId, String userName, String userPassword, long orderId, long saleOrderId, long saleReferenceId) {
        return null;
    }

    @Override
    public String bpRefundRequestV2(long terminalId, String userName, String userPassword, String destinationPan, String mobileNo, long orderId, long saleOrderId, long saleReferenceId, long refundAmount) {
        return null;
    }

    @Override
    public Boolean soh() {
        return null;
    }

    @Override
    public String bpChargePayRequest(long terminalId, String userName, String userPassword, long orderId, long amount, String localDate, String localTime, String additionalData, String callBackUrl, String payerId) {
        return null;
    }

    @Override
    public String bpCumulativeDynamicPayRequest(long terminalId, String userName, String userPassword, long orderId, long amount, String localDate, String localTime, String additionalData, String callBackUrl, String mobileNo, String encPan, String panHiddenMode, String cartItem, String enc) {
        return null;
    }

    @Override
    public String bpPayRequest(long terminalId, String userName, String userPassword, long orderId, long amount, String localDate, String localTime, String additionalData, String callBackUrl, String payerId, String mobileNo, String encPan, String panHiddenMode, String cartItem, String enc) {
        return null;
    }

/*    @Override
    public String bpCumulativeDynamicPayRequest(long terminalId, String userName, String userPassword, long orderId, long amount, String localDate, String localTime, String additionalData, String callBackUrl) {
        return null;
    }*/

//    @Override
    public String bpPayRequest(long terminalId, String userName, String userPassword, long orderId, long amount, String localDate, String localTime, String additionalData, String callBackUrl, String payerId) {
        BpPayRequest bpPayRequest = new BpPayRequest();
//        bpPayRequest.setCallBackUrl("http://77.104.84.251:8080/edu-imi-ws/api/v1/reqres/bankResponse");
        bpPayRequest.setCallBackUrl("http://ashouri-pc.imi.ir:8080/edu-imi-ws/api/v1/reqres/bankResponse");
        bpPayRequest.setAmount(10000);
//        MAINPARTS.SEQ_RESERVATION_NUMBER
        bpPayRequest.setOrderId(7000023l);
        bpPayRequest.setLocalDate("20200706");
        bpPayRequest.setLocalTime("082711");
        bpPayRequest.setAdditionalData("for test 3");
        bpPayRequest.setTerminalId(1);
        bpPayRequest.setUserName("1");
        bpPayRequest.setUserPassword("1");
//        Object oo = getWebServiceTemplate().marshalSendAndReceive(new ObjectFactory().createBpPayRequest(bpPayRequest));
         Object oo = getWebServiceTemplate().marshalSendAndReceive(new ObjectFactory().createBpPayRequest(bpPayRequest));

         BpPayRequestResponse bpPayRequestResponse =  ((JAXBElement<BpPayRequestResponse>) oo).getValue();
         //         new ObjectFactory().createBpPayRequestResponse((BpPayRequestResponse) oo);
//        BpPayRequestResponse bpPayRequestResponse = new BpPayRequestResponse();
        System.out.println(oo.toString());
        return String.valueOf(oo);
//        return null;
    }

    @Override
    public String bpRefundInquiryRequest(long terminalId, String userName, String userPassword, long orderId, long refundOrderId, long refundReferenceId) {
        return null;
    }

    @Override
    public String bpReversalRequest(long terminalId, String userName, String userPassword, long orderId, long saleOrderId, long saleReferenceId) {
        return null;
    }

    @Override
    public String bpPosRefundRequest(String user, String password, long saleReferenceId, long refundAmount) {
        return null;
    }

    @Override
    public String bpRefundToPANRequest(String user, String password, Long pan, long amount, Long saleReferenceId, long terminalId, String mobileNo, long orderId) {
        return null;
    }

    @Override
    public String bpVerifyRequest(long terminalId, String userName, String userPassword, long orderId, long saleOrderId, long saleReferenceId) {
        return null;
    }

    @Override
    public String bpRefundVerifyRequest(long terminalId, String userName, String userPassword, long orderId, long refundOrderId, long refundReferenceId) {
        return null;
    }

/*    @Override
    public String bpPayRequest(long terminalId, String userName, String userPassword,
                               long orderId, long amount, String localDate,
                               String localTime, String additionalData, String callBackUrl,
                               long payerId) {
        BpPayRequest bpPayRequest = new BpPayRequest();
        bpPayRequest.setCallBackUrl("http://www.imi.ir/Pages/home.aspx");
        bpPayRequest.setAmount(1000);
//        MAINPARTS.SEQ_RESERVATION_NUMBER
        bpPayRequest.setOrderId(1234567890l);
        bpPayRequest.setLocalDate("20200601");
        bpPayRequest.setLocalTime("114110");
        bpPayRequest.setAdditionalData("for test 2");
        bpPayRequest.setTerminalId(818149l);
        bpPayRequest.setUserName("erpimi");
        bpPayRequest.setUserPassword("58975627");
        Object oo = getWebServiceTemplate().marshalSendAndReceive(new ObjectFactory().createBpPayRequest(bpPayRequest));
        return String.valueOf(oo);
    }*/

}
