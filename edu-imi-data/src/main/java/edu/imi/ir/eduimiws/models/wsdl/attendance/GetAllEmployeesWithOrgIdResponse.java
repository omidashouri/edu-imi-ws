
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
 *         <element name="GetAllEmployeesWithOrgIdResult" type="{http://tempuri.org/}ArrayOfEmployeeInfo" minOccurs="0"/>
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
    "getAllEmployeesWithOrgIdResult"
})
@XmlRootElement(name = "GetAllEmployeesWithOrgIdResponse")
public class GetAllEmployeesWithOrgIdResponse {

    @XmlElement(name = "GetAllEmployeesWithOrgIdResult")
    protected ArrayOfEmployeeInfo getAllEmployeesWithOrgIdResult;

    /**
     * Gets the value of the getAllEmployeesWithOrgIdResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfEmployeeInfo }
     *     
     */
    public ArrayOfEmployeeInfo getGetAllEmployeesWithOrgIdResult() {
        return getAllEmployeesWithOrgIdResult;
    }

    /**
     * Sets the value of the getAllEmployeesWithOrgIdResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfEmployeeInfo }
     *     
     */
    public void setGetAllEmployeesWithOrgIdResult(ArrayOfEmployeeInfo value) {
        this.getAllEmployeesWithOrgIdResult = value;
    }

}
