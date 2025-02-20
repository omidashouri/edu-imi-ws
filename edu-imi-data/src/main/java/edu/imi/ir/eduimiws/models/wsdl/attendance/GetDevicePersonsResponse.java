
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="GetDevicePersonsResult" type="{http://tempuri.org/}ArrayOfDevicePerson" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
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
