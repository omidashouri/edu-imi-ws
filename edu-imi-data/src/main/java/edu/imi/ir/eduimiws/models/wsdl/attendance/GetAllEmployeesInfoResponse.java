
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
 *         <element name="GetAllEmployeesInfoResult" type="{http://tempuri.org/}ArrayOfEmployeeInfo" minOccurs="0"/>
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
    "getAllEmployeesInfoResult"
})
@XmlRootElement(name = "GetAllEmployeesInfoResponse")
public class GetAllEmployeesInfoResponse {

    @XmlElement(name = "GetAllEmployeesInfoResult")
    protected ArrayOfEmployeeInfo getAllEmployeesInfoResult;

    /**
     * Gets the value of the getAllEmployeesInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfEmployeeInfo }
     *     
     */
    public ArrayOfEmployeeInfo getGetAllEmployeesInfoResult() {
        return getAllEmployeesInfoResult;
    }

    /**
     * Sets the value of the getAllEmployeesInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfEmployeeInfo }
     *     
     */
    public void setGetAllEmployeesInfoResult(ArrayOfEmployeeInfo value) {
        this.getAllEmployeesInfoResult = value;
    }

}
