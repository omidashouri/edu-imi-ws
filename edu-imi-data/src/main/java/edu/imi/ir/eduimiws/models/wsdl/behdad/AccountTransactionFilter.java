
package edu.imi.ir.eduimiws.models.wsdl.behdad;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for accountTransactionFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accountTransactionFilter"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fromDateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paymentIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="toDateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountTransactionFilter", propOrder = {
    "accountNumber",
    "fromDateTime",
    "paymentIdentifier",
    "toDateTime"
})
public class AccountTransactionFilter {

    protected String accountNumber;
    protected String fromDateTime;
    protected String paymentIdentifier;
    protected String toDateTime;

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the fromDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromDateTime() {
        return fromDateTime;
    }

    /**
     * Sets the value of the fromDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromDateTime(String value) {
        this.fromDateTime = value;
    }

    /**
     * Gets the value of the paymentIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentIdentifier() {
        return paymentIdentifier;
    }

    /**
     * Sets the value of the paymentIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentIdentifier(String value) {
        this.paymentIdentifier = value;
    }

    /**
     * Gets the value of the toDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToDateTime() {
        return toDateTime;
    }

    /**
     * Sets the value of the toDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToDateTime(String value) {
        this.toDateTime = value;
    }

}
