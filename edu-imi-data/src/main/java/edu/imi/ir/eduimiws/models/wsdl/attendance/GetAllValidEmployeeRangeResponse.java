
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
 *         <element name="GetAllValidEmployeeRangeResult" type="{http://tempuri.org/}ArrayOfValidEmployeeRange" minOccurs="0"/>
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
