package edu.imi.ir.eduimiws.services.api.reqres;

import edu.imi.ir.eduimiws.models.wsdl.BpPayRequest;
import edu.imi.ir.eduimiws.models.wsdl.IPaymentGateway;
import edu.imi.ir.eduimiws.models.wsdl.ObjectFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

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
    public String bpDynamicPayRequest(long terminalId, String userName, String userPassword, long orderId, long amount, String localDate, String localTime, String additionalData, String callBackUrl, String payerId, long subServiceId) {
        return null;
    }

    @Override
    public String bpInquiryRequest(long terminalId, String userName, String userPassword, long orderId, long saleOrderId, long saleReferenceId) {
        return null;
    }

    @Override
    public String bpSettleRequest(long terminalId, String userName, String userPassword, long orderId, long saleOrderId, long saleReferenceId) {
        return null;
    }

    @Override
    public String bpChargePayRequest(long terminalId, String userName, String userPassword, long orderId, long amount, String localDate, String localTime, String additionalData, String callBackUrl, String payerId) {
        return null;
    }

    @Override
    public String bpCumulativeDynamicPayRequest(long terminalId, String userName, String userPassword, long orderId, long amount, String localDate, String localTime, String additionalData, String callBackUrl) {
        return null;
    }

    @Override
    public String bpPayRequest(long terminalId, String userName, String userPassword, long orderId, long amount, String localDate, String localTime, String additionalData, String callBackUrl, String payerId) {
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
