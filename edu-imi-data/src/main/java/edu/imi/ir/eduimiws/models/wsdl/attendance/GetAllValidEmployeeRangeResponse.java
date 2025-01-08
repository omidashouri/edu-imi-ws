
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
 *         &lt;element name="GetAllValidEmployeeRangeResult" type="{http://tempuri.org/}ArrayOfValidEmployeeRange" minOccurs="0"/&gt;
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
    "getAllValidEmployeeRangeResult"
})
@XmlRootElement(name = "GetAllValidEmployeeRangeResponse")
public class GetAllValidEmployeeRangeResponse {

    @XmlElement(name = "GetAllValidEmployeeRangeResult")
    protected ArrayOfValidEmployeeRange getAllValidEmployeeRangeResult;

    /**
     * Gets the value of the getAllValidEmployeeRangeResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfValidEmployeeRange }
     *     
     */
    public ArrayOfValidEmployeeRange getGetAllValidEmployeeRangeResult() {
        return getAllValidEmployeeRangeResult;
    }

    /**
     * Sets the value of the getAllValidEmployeeRangeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfValidEmployeeRange }
     *     
     */
    public void setGetAllValidEmployeeRangeResult(ArrayOfValidEmployeeRange value) {
        this.getAllValidEmployeeRangeResult = value;
    }

}
