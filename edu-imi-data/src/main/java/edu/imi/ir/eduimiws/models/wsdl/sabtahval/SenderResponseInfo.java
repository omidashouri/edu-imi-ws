//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2025.01.30 at 02:03:28 PM GMT+03:30 
//


package edu.imi.ir.eduimiws.models.wsdl.sabtahval;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import edu.imi.ir.eduimiws.models.sabtahval.adapter.LocalDateTimeAdapter;


/**
 * <p>Java class for senderResponseInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="senderResponseInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="responseDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="xmlResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "senderResponseInfo", propOrder = {
    "message",
    "responseDate",
    "xmlResponse"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
public class SenderResponseInfo
    implements Serializable
{

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    private final static long serialVersionUID = 1L;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    protected String message;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @XmlSchemaType(name = "dateTime")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    protected LocalDateTime responseDate;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    protected String xmlResponse;

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the responseDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    public LocalDateTime getResponseDate() {
        return responseDate;
    }

    /**
     * Sets the value of the responseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    public void setResponseDate(LocalDateTime value) {
        this.responseDate = value;
    }

    /**
     * Gets the value of the xmlResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    public String getXmlResponse() {
        return xmlResponse;
    }

    /**
     * Sets the value of the xmlResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2025-01-30T02:03:28+03:30", comments = "JAXB RI v2.3.2")
    public void setXmlResponse(String value) {
        this.xmlResponse = value;
    }

}
