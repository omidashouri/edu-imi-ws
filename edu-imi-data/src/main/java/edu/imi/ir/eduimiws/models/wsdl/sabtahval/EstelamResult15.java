//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2025.01.30 at 02:03:28 PM GMT+03:30 
//


package edu.imi.ir.eduimiws.models.wsdl.sabtahval;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EstelamResult15 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EstelamResult15"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="zipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *         &lt;element name="messageList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="errorMessageList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="trackingInfo" type="{http://est}TrackingInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EstelamResult15", propOrder = {
    "zipCode",
    "address",
    "messageLists",
    "errorMessageLists",
    "trackingInfo"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
public class EstelamResult15
    implements Serializable
{

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    private final static long serialVersionUID = 1L;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    protected String zipCode;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    protected byte[] address;
    @XmlElement(name = "messageList", nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    protected List<String> messageLists;
    @XmlElement(name = "errorMessageList", nillable = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    protected List<String> errorMessageLists;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    protected TrackingInfo trackingInfo;

    /**
     * Gets the value of the zipCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the value of the zipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    public void setZipCode(String value) {
        this.zipCode = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    public byte[] getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    public void setAddress(byte[] value) {
        this.address = value;
    }

    /**
     * Gets the value of the messageLists property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messageLists property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageLists().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    public List<String> getMessageLists() {
        if (messageLists == null) {
            messageLists = new ArrayList<String>();
        }
        return this.messageLists;
    }

    /**
     * Gets the value of the errorMessageLists property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the errorMessageLists property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErrorMessageLists().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    public List<String> getErrorMessageLists() {
        if (errorMessageLists == null) {
            errorMessageLists = new ArrayList<String>();
        }
        return this.errorMessageLists;
    }

    /**
     * Gets the value of the trackingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TrackingInfo }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    public TrackingInfo getTrackingInfo() {
        return trackingInfo;
    }

    /**
     * Sets the value of the trackingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackingInfo }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    public void setTrackingInfo(TrackingInfo value) {
        this.trackingInfo = value;
    }

}
