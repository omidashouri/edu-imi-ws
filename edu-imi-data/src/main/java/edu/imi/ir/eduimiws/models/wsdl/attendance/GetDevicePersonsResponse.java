
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetDevicePersonsResult" type="{http://tempuri.org/}ArrayOfDevicePerson" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getDevicePersonsResult"
})
@XmlRootElement(name = "GetDevicePersonsResponse")
public class GetDevicePersonsResponse {

    @XmlElement(name = "GetDevicePersonsResult")
    protected ArrayOfDevicePerson getDevicePersonsResult;

    /**
     * Gets the value of the getDevicePersonsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDevicePerson }
     *     
     */
    public ArrayOfDevicePerson getGetDevicePersonsResult() {
        return getDevicePersonsResult;
    }

    /**
     * Sets the value of the getDevicePersonsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDevicePerson }
     *     
     */
    public void setGetDevicePersonsResult(ArrayOfDevicePerson value) {
        this.getDevicePersonsResult = value;
    }

}
