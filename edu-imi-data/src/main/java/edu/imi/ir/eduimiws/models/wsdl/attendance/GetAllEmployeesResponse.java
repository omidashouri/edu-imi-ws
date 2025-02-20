
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
 *         <element name="GetAllEmployeesResult" type="{http://tempuri.org/}ArrayOfEmployeeDataModel" minOccurs="0"/>
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
    "getAllEmployeesResult"
})
@XmlRootElement(name = "GetAllEmployeesResponse")
public class GetAllEmployeesResponse {

    @XmlElement(name = "GetAllEmployeesResult")
    protected ArrayOfEmployeeDataModel getAllEmployeesResult;

    /**
     * Gets the value of the getAllEmployeesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfEmployeeDataModel }
     *     
     */
    public ArrayOfEmployeeDataModel getGetAllEmployeesResult() {
        return getAllEmployeesResult;
    }

    /**
     * Sets the value of the getAllEmployeesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfEmployeeDataModel }
     *     
     */
    public void setGetAllEmployeesResult(ArrayOfEmployeeDataModel value) {
        this.getAllEmployeesResult = value;
    }

}
