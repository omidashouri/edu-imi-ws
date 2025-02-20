
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
 *         <element name="GetAllCurrentlyEmployeesWithKeyResult" type="{http://tempuri.org/}ArrayOfEmployeeDataModelWithKey" minOccurs="0"/>
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
    "getAllCurrentlyEmployeesWithKeyResult"
})
@XmlRootElement(name = "GetAllCurrentlyEmployeesWithKeyResponse")
public class GetAllCurrentlyEmployeesWithKeyResponse {

    @XmlElement(name = "GetAllCurrentlyEmployeesWithKeyResult")
    protected ArrayOfEmployeeDataModelWithKey getAllCurrentlyEmployeesWithKeyResult;

    /**
     * Gets the value of the getAllCurrentlyEmployeesWithKeyResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfEmployeeDataModelWithKey }
     *     
     */
    public ArrayOfEmployeeDataModelWithKey getGetAllCurrentlyEmployeesWithKeyResult() {
        return getAllCurrentlyEmployeesWithKeyResult;
    }

    /**
     * Sets the value of the getAllCurrentlyEmployeesWithKeyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfEmployeeDataModelWithKey }
     *     
     */
    public void setGetAllCurrentlyEmployeesWithKeyResult(ArrayOfEmployeeDataModelWithKey value) {
        this.getAllCurrentlyEmployeesWithKeyResult = value;
    }

}
