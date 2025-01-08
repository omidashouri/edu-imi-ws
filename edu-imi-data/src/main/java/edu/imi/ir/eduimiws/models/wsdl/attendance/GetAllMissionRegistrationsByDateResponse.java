
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
 *         &lt;element name="GetAllMissionRegistrationsByDateResult" type="{http://tempuri.org/}ArrayOfMissionRegistrationDataModel" minOccurs="0"/&gt;
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
    "getAllMissionRegistrationsByDateResult"
})
@XmlRootElement(name = "GetAllMissionRegistrationsByDateResponse")
public class GetAllMissionRegistrationsByDateResponse {

    @XmlElement(name = "GetAllMissionRegistrationsByDateResult")
    protected ArrayOfMissionRegistrationDataModel getAllMissionRegistrationsByDateResult;

    /**
     * Gets the value of the getAllMissionRegistrationsByDateResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMissionRegistrationDataModel }
     *     
     */
    public ArrayOfMissionRegistrationDataModel getGetAllMissionRegistrationsByDateResult() {
        return getAllMissionRegistrationsByDateResult;
    }

    /**
     * Sets the value of the getAllMissionRegistrationsByDateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMissionRegistrationDataModel }
     *     
     */
    public void setGetAllMissionRegistrationsByDateResult(ArrayOfMissionRegistrationDataModel value) {
        this.getAllMissionRegistrationsByDateResult = value;
    }

}
