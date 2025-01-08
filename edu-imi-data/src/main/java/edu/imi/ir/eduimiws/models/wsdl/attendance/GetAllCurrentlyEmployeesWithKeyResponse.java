
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
 *         &lt;element name="GetAllCurrentlyEmployeesWithKeyResult" type="{http://tempuri.org/}ArrayOfEmployeeDataModelWithKey" minOccurs="0"/&gt;
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
