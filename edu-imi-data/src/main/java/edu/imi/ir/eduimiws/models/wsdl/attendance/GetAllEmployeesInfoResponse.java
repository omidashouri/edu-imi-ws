
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
 *         &lt;element name="GetAllEmployeesInfoResult" type="{http://tempuri.org/}ArrayOfEmployeeInfo" minOccurs="0"/&gt;
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
