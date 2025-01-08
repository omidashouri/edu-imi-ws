
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
 *         &lt;element name="GetAllCurrentlyEmployeesResult" type="{http://tempuri.org/}ArrayOfEmployeeDataModel" minOccurs="0"/&gt;
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
    "getAllCurrentlyEmployeesResult"
})
@XmlRootElement(name = "GetAllCurrentlyEmployeesResponse")
public class GetAllCurrentlyEmployeesResponse {

    @XmlElement(name = "GetAllCurrentlyEmployeesResult")
    protected ArrayOfEmployeeDataModel getAllCurrentlyEmployeesResult;

    /**
     * Gets the value of the getAllCurrentlyEmployeesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfEmployeeDataModel }
     *     
     */
    public ArrayOfEmployeeDataModel getGetAllCurrentlyEmployeesResult() {
        return getAllCurrentlyEmployeesResult;
    }

    /**
     * Sets the value of the getAllCurrentlyEmployeesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfEmployeeDataModel }
     *     
     */
    public void setGetAllCurrentlyEmployeesResult(ArrayOfEmployeeDataModel value) {
        this.getAllCurrentlyEmployeesResult = value;
    }

}
