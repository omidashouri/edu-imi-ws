
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
 *         <element name="AddVacationRegistrationResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "addVacationRegistrationResult"
})
@XmlRootElement(name = "AddVacationRegistrationResponse")
public class AddVacationRegistrationResponse {

    @XmlElement(name = "AddVacationRegistrationResult")
    protected String addVacationRegistrationResult;

    /**
     * Gets the value of the addVacationRegistrationResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddVacationRegistrationResult() {
        return addVacationRegistrationResult;
    }

    /**
     * Sets the value of the addVacationRegistrationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddVacationRegistrationResult(String value) {
        this.addVacationRegistrationResult = value;
    }

}
