
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
 *         &lt;element name="GetAllEmployeesWithOrgIdResult" type="{http://tempuri.org/}ArrayOfEmployeeInfo" minOccurs="0"/&gt;
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
