
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
 *         &lt;element name="GetAllVacationRegistrationsByDateResult" type="{http://tempuri.org/}ArrayOfVacationRegistrationDataModel" minOccurs="0"/&gt;
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
    "getAllVacationRegistrationsByDateResult"
})
@XmlRootElement(name = "GetAllVacationRegistrationsByDateResponse")
public class GetAllVacationRegistrationsByDateResponse {

    @XmlElement(name = "GetAllVacationRegistrationsByDateResult")
    protected ArrayOfVacationRegistrationDataModel getAllVacationRegistrationsByDateResult;

    /**
     * Gets the value of the getAllVacationRegistrationsByDateResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVacationRegistrationDataModel }
     *     
     */
    public ArrayOfVacationRegistrationDataModel getGetAllVacationRegistrationsByDateResult() {
        return getAllVacationRegistrationsByDateResult;
    }

    /**
     * Sets the value of the getAllVacationRegistrationsByDateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVacationRegistrationDataModel }
     *     
     */
    public void setGetAllVacationRegistrationsByDateResult(ArrayOfVacationRegistrationDataModel value) {
        this.getAllVacationRegistrationsByDateResult = value;
    }

}
