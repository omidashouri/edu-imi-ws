
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
 *         <element name="GetAllSpecialExtraWorksByPeriodIdResult" type="{http://tempuri.org/}ArrayOfSpecialExtraWorkDataModel" minOccurs="0"/>
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
