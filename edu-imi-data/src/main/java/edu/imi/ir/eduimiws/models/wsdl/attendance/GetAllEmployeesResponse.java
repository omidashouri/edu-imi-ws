
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
 *         &lt;element name="GetAllEmployeesResult" type="{http://tempuri.org/}ArrayOfEmployeeDataModel" minOccurs="0"/&gt;
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
