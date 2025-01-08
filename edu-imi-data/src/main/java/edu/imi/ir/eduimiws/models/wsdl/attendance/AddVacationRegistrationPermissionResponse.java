
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
 *         &lt;element name="AddVacationRegistrationPermissionResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "addVacationRegistrationPermissionResult"
})
@XmlRootElement(name = "AddVacationRegistrationPermissionResponse")
public class AddVacationRegistrationPermissionResponse {

    @XmlElement(name = "AddVacationRegistrationPermissionResult")
    protected String addVacationRegistrationPermissionResult;

    /**
     * Gets the value of the addVacationRegistrationPermissionResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddVacationRegistrationPermissionResult() {
        return addVacationRegistrationPermissionResult;
    }

    /**
     * Sets the value of the addVacationRegistrationPermissionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddVacationRegistrationPermissionResult(String value) {
        this.addVacationRegistrationPermissionResult = value;
    }

}
