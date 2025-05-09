
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package edu.imi.ir.eduimiws.models.wsdl.mellat;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.6.5
 * 2025-01-08T17:24:18.711+03:30
 * Generated source version: 3.6.5
 *
 */

@javax.jws.WebService(
                      serviceName = "$service.ServiceName",
                      targetNamespace = "$service.Namespace",
                      wsdlLocation = "https://bpm.shaparak.ir/pgwchannel/services/pgw?wsdl=IPaymentGateway.wsdl",
                      endpointInterface = "edu.imi.ir.eduimiws.models.wsdl.IPaymentGateway")

public class IPaymentGatewayImpl implements IPaymentGateway {

    private static final Logger LOG = Logger.getLogger(IPaymentGatewayImpl.class.getName());

    /* (non-Javadoc)
     * @see edu.imi.ir.eduimiws.models.wsdl.IPaymentGateway#bpRefundRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long saleOrderId, long saleReferenceId, long refundAmount)*
     */
    public java.lang.String bpRefundRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long saleOrderId, long saleReferenceId, long refundAmount) {
        LOG.info("Executing operation bpRefundRequest");
        System.out.println(terminalId);
        System.out.println(userName);
        System.out.println(userPassword);
        System.out.println(orderId);
        System.out.println(saleOrderId);
        System.out.println(saleReferenceId);
        System.out.println(refundAmount);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see edu.imi.ir.eduimiws.models.wsdl.IPaymentGateway#bpSaleReferenceIdRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long saleOrderId)*
     */
    public java.lang.String bpSaleReferenceIdRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long saleOrderId) {
        LOG.info("Executing operation bpSaleReferenceIdRequest");
        System.out.println(terminalId);
        System.out.println(userName);
        System.out.println(userPassword);
        System.out.println(orderId);
        System.out.println(saleOrderId);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see edu.imi.ir.eduimiws.models.wsdl.IPaymentGateway#bpRefundToPANRequestV2(java.lang.String user, java.lang.String password, java.lang.Long pan, long amount, java.lang.Long saleReferenceId, long terminalId, long orderId, java.lang.String mobileNo)*
     */
    public java.lang.String bpRefundToPANRequestV2(java.lang.String user, java.lang.String password, java.lang.Long pan, long amount, java.lang.Long saleReferenceId, long terminalId, long orderId, java.lang.String mobileNo) {
        LOG.info("Executing operation bpRefundToPANRequestV2");
        System.out.println(user);
        System.out.println(password);
        System.out.println(pan);
        System.out.println(amount);
        System.out.println(saleReferenceId);
        System.out.println(terminalId);
        System.out.println(orderId);
        System.out.println(mobileNo);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see edu.imi.ir.eduimiws.models.wsdl.IPaymentGateway#bpDynamicPayRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long amount, java.lang.String localDate, java.lang.String localTime, java.lang.String additionalData, java.lang.String callBackUrl, java.lang.String payerId, long subServiceId, java.lang.String mobileNo, java.lang.String encPan, java.lang.String panHiddenMode, java.lang.String cartItem, java.lang.String enc)*
     */
    public java.lang.String bpDynamicPayRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long amount, java.lang.String localDate, java.lang.String localTime, java.lang.String additionalData, java.lang.String callBackUrl, java.lang.String payerId, long subServiceId, java.lang.String mobileNo, java.lang.String encPan, java.lang.String panHiddenMode, java.lang.String cartItem, java.lang.String enc) {
        LOG.info("Executing operation bpDynamicPayRequest");
        System.out.println(terminalId);
        System.out.println(userName);
        System.out.println(userPassword);
        System.out.println(orderId);
        System.out.println(amount);
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(additionalData);
        System.out.println(callBackUrl);
        System.out.println(payerId);
        System.out.println(subServiceId);
        System.out.println(mobileNo);
        System.out.println(encPan);
        System.out.println(panHiddenMode);
        System.out.println(cartItem);
        System.out.println(enc);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see edu.imi.ir.eduimiws.models.wsdl.IPaymentGateway#bpInquiryRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long saleOrderId, long saleReferenceId)*
     */
    public java.lang.String bpInquiryRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long saleOrderId, long saleReferenceId) {
        LOG.info("Executing operation bpInquiryRequest");
        System.out.println(terminalId);
        System.out.println(userName);
        System.out.println(userPassword);
        System.out.println(orderId);
        System.out.println(saleOrderId);
        System.out.println(saleReferenceId);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see edu.imi.ir.eduimiws.models.wsdl.IPaymentGateway#bpSettleRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long saleOrderId, long saleReferenceId)*
     */
    public java.lang.String bpSettleRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long saleOrderId, long saleReferenceId) {
        LOG.info("Executing operation bpSettleRequest");
        System.out.println(terminalId);
        System.out.println(userName);
        System.out.println(userPassword);
        System.out.println(orderId);
        System.out.println(saleOrderId);
        System.out.println(saleReferenceId);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see edu.imi.ir.eduimiws.models.wsdl.IPaymentGateway#bpVerifySettleRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long saleOrderId, long saleReferenceId)*
     */
    public java.lang.String bpVerifySettleRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long saleOrderId, long saleReferenceId) {
        LOG.info("Executing operation bpVerifySettleRequest");
        System.out.println(terminalId);
        System.out.println(userName);
        System.out.println(userPassword);
        System.out.println(orderId);
        System.out.println(saleOrderId);
        System.out.println(saleReferenceId);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see edu.imi.ir.eduimiws.models.wsdl.IPaymentGateway#bpRefundRequestV2(long terminalId, java.lang.String userName, java.lang.String userPassword, java.lang.String destinationPan, java.lang.String mobileNo, long orderId, long saleOrderId, long saleReferenceId, long refundAmount)*
     */
    public java.lang.String bpRefundRequestV2(long terminalId, java.lang.String userName, java.lang.String userPassword, java.lang.String destinationPan, java.lang.String mobileNo, long orderId, long saleOrderId, long saleReferenceId, long refundAmount) {
        LOG.info("Executing operation bpRefundRequestV2");
        System.out.println(terminalId);
        System.out.println(userName);
        System.out.println(userPassword);
        System.out.println(destinationPan);
        System.out.println(mobileNo);
        System.out.println(orderId);
        System.out.println(saleOrderId);
        System.out.println(saleReferenceId);
        System.out.println(refundAmount);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see edu.imi.ir.eduimiws.models.wsdl.IPaymentGateway#soh()*
     */
    public java.lang.Boolean soh() {
        LOG.info("Executing operation soh");
        try {
            java.lang.Boolean _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see edu.imi.ir.eduimiws.models.wsdl.IPaymentGateway#bpChargePayRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long amount, java.lang.String localDate, java.lang.String localTime, java.lang.String additionalData, java.lang.String callBackUrl, java.lang.String payerId)*
     */
    public java.lang.String bpChargePayRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long amount, java.lang.String localDate, java.lang.String localTime, java.lang.String additionalData, java.lang.String callBackUrl, java.lang.String payerId) {
        LOG.info("Executing operation bpChargePayRequest");
        System.out.println(terminalId);
        System.out.println(userName);
        System.out.println(userPassword);
        System.out.println(orderId);
        System.out.println(amount);
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(additionalData);
        System.out.println(callBackUrl);
        System.out.println(payerId);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see edu.imi.ir.eduimiws.models.wsdl.IPaymentGateway#bpCumulativeDynamicPayRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long amount, java.lang.String localDate, java.lang.String localTime, java.lang.String additionalData, java.lang.String callBackUrl, java.lang.String mobileNo, java.lang.String encPan, java.lang.String panHiddenMode, java.lang.String cartItem, java.lang.String enc)*
     */
    public java.lang.String bpCumulativeDynamicPayRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long amount, java.lang.String localDate, java.lang.String localTime, java.lang.String additionalData, java.lang.String callBackUrl, java.lang.String mobileNo, java.lang.String encPan, java.lang.String panHiddenMode, java.lang.String cartItem, java.lang.String enc) {
        LOG.info("Executing operation bpCumulativeDynamicPayRequest");
        System.out.println(terminalId);
        System.out.println(userName);
        System.out.println(userPassword);
        System.out.println(orderId);
        System.out.println(amount);
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(additionalData);
        System.out.println(callBackUrl);
        System.out.println(mobileNo);
        System.out.println(encPan);
        System.out.println(panHiddenMode);
        System.out.println(cartItem);
        System.out.println(enc);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see edu.imi.ir.eduimiws.models.wsdl.IPaymentGateway#bpPayRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long amount, java.lang.String localDate, java.lang.String localTime, java.lang.String additionalData, java.lang.String callBackUrl, java.lang.String payerId, java.lang.String mobileNo, java.lang.String encPan, java.lang.String panHiddenMode, java.lang.String cartItem, java.lang.String enc)*
     */
    public java.lang.String bpPayRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long amount, java.lang.String localDate, java.lang.String localTime, java.lang.String additionalData, java.lang.String callBackUrl, java.lang.String payerId, java.lang.String mobileNo, java.lang.String encPan, java.lang.String panHiddenMode, java.lang.String cartItem, java.lang.String enc) {
        LOG.info("Executing operation bpPayRequest");
        System.out.println(terminalId);
        System.out.println(userName);
        System.out.println(userPassword);
        System.out.println(orderId);
        System.out.println(amount);
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(additionalData);
        System.out.println(callBackUrl);
        System.out.println(payerId);
        System.out.println(mobileNo);
        System.out.println(encPan);
        System.out.println(panHiddenMode);
        System.out.println(cartItem);
        System.out.println(enc);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see edu.imi.ir.eduimiws.models.wsdl.IPaymentGateway#bpRefundInquiryRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long refundOrderId, long refundReferenceId)*
     */
    public java.lang.String bpRefundInquiryRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long refundOrderId, long refundReferenceId) {
        LOG.info("Executing operation bpRefundInquiryRequest");
        System.out.println(terminalId);
        System.out.println(userName);
        System.out.println(userPassword);
        System.out.println(orderId);
        System.out.println(refundOrderId);
        System.out.println(refundReferenceId);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see edu.imi.ir.eduimiws.models.wsdl.IPaymentGateway#bpReversalRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long saleOrderId, long saleReferenceId)*
     */
    public java.lang.String bpReversalRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long saleOrderId, long saleReferenceId) {
        LOG.info("Executing operation bpReversalRequest");
        System.out.println(terminalId);
        System.out.println(userName);
        System.out.println(userPassword);
        System.out.println(orderId);
        System.out.println(saleOrderId);
        System.out.println(saleReferenceId);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see edu.imi.ir.eduimiws.models.wsdl.IPaymentGateway#bpPosRefundRequest(java.lang.String user, java.lang.String password, long saleReferenceId, long refundAmount)*
     */
    public java.lang.String bpPosRefundRequest(java.lang.String user, java.lang.String password, long saleReferenceId, long refundAmount) {
        LOG.info("Executing operation bpPosRefundRequest");
        System.out.println(user);
        System.out.println(password);
        System.out.println(saleReferenceId);
        System.out.println(refundAmount);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see edu.imi.ir.eduimiws.models.wsdl.IPaymentGateway#bpRefundToPANRequest(java.lang.String user, java.lang.String password, java.lang.Long pan, long amount, java.lang.Long saleReferenceId, long terminalId, java.lang.String mobileNo, long orderId)*
     */
    public java.lang.String bpRefundToPANRequest(java.lang.String user, java.lang.String password, java.lang.Long pan, long amount, java.lang.Long saleReferenceId, long terminalId, java.lang.String mobileNo, long orderId) {
        LOG.info("Executing operation bpRefundToPANRequest");
        System.out.println(user);
        System.out.println(password);
        System.out.println(pan);
        System.out.println(amount);
        System.out.println(saleReferenceId);
        System.out.println(terminalId);
        System.out.println(mobileNo);
        System.out.println(orderId);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see edu.imi.ir.eduimiws.models.wsdl.IPaymentGateway#bpVerifyRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long saleOrderId, long saleReferenceId)*
     */
    public java.lang.String bpVerifyRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long saleOrderId, long saleReferenceId) {
        LOG.info("Executing operation bpVerifyRequest");
        System.out.println(terminalId);
        System.out.println(userName);
        System.out.println(userPassword);
        System.out.println(orderId);
        System.out.println(saleOrderId);
        System.out.println(saleReferenceId);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see edu.imi.ir.eduimiws.models.wsdl.IPaymentGateway#bpRefundVerifyRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long refundOrderId, long refundReferenceId)*
     */
    public java.lang.String bpRefundVerifyRequest(long terminalId, java.lang.String userName, java.lang.String userPassword, long orderId, long refundOrderId, long refundReferenceId) {
        LOG.info("Executing operation bpRefundVerifyRequest");
        System.out.println(terminalId);
        System.out.println(userName);
        System.out.println(userPassword);
        System.out.println(orderId);
        System.out.println(refundOrderId);
        System.out.println(refundReferenceId);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
