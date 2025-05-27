
package edu.imi.ir.eduimiws.models.wsdl.behdad;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for multipleAccountTransactionFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="multipleAccountTransactionFilter"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountNumbers" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "multipleAccountTransactionFilter", propOrder = {
    "accountNumbers",
    "fromDateTime",
    "paymentIdentifier",
    "toDateTime"
})
public class MultipleAccountTransactionFilter {

    @XmlElement(nillable = true)
    protected List<String> accountNumbers;
    protected String fromDateTime;
    protected String paymentIdentifier;
    protected String toDateTime;

    /**
     * Gets the value of the accountNumbers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accountNumbers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccountNumbers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAccountNumbers() {
        if (accountNumbers == null) {
            accountNumbers = new ArrayList<String>();
        }
        return this.accountNumbers;
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
