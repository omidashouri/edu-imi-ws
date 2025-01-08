
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
 *         &lt;element name="GetAllSpecialExtraWorksByPeriodIdResult" type="{http://tempuri.org/}ArrayOfSpecialExtraWorkDataModel" minOccurs="0"/&gt;
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
    "getAllSpecialExtraWorksByPeriodIdResult"
})
@XmlRootElement(name = "GetAllSpecialExtraWorksByPeriodIdResponse")
public class GetAllSpecialExtraWorksByPeriodIdResponse {

    @XmlElement(name = "GetAllSpecialExtraWorksByPeriodIdResult")
    protected ArrayOfSpecialExtraWorkDataModel getAllSpecialExtraWorksByPeriodIdResult;

    /**
     * Gets the value of the getAllSpecialExtraWorksByPeriodIdResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSpecialExtraWorkDataModel }
     *     
     */
    public ArrayOfSpecialExtraWorkDataModel getGetAllSpecialExtraWorksByPeriodIdResult() {
        return getAllSpecialExtraWorksByPeriodIdResult;
    }

    /**
     * Sets the value of the getAllSpecialExtraWorksByPeriodIdResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSpecialExtraWorkDataModel }
     *     
     */
    public void setGetAllSpecialExtraWorksByPeriodIdResult(ArrayOfSpecialExtraWorkDataModel value) {
        this.getAllSpecialExtraWorksByPeriodIdResult = value;
    }

}
