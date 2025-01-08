
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
 *         &lt;element name="AddMissionRegistrationExResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "addMissionRegistrationExResult"
})
@XmlRootElement(name = "AddMissionRegistrationExResponse")
public class AddMissionRegistrationExResponse {

    @XmlElement(name = "AddMissionRegistrationExResult")
    protected String addMissionRegistrationExResult;

    /**
     * Gets the value of the addMissionRegistrationExResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddMissionRegistrationExResult() {
        return addMissionRegistrationExResult;
    }

    /**
     * Sets the value of the addMissionRegistrationExResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddMissionRegistrationExResult(String value) {
        this.addMissionRegistrationExResult = value;
    }

}
