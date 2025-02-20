
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
 *         <element name="GetAllPeriodFunctionalityWinPayListResult" type="{http://tempuri.org/}ArrayOfPeriodCalculationInfo" minOccurs="0"/>
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
    "getAllPeriodFunctionalityWinPayListResult"
})
@XmlRootElement(name = "GetAllPeriodFunctionalityWinPayListResponse")
public class GetAllPeriodFunctionalityWinPayListResponse {

    @XmlElement(name = "GetAllPeriodFunctionalityWinPayListResult")
    protected ArrayOfPeriodCalculationInfo getAllPeriodFunctionalityWinPayListResult;

    /**
     * Gets the value of the getAllPeriodFunctionalityWinPayListResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPeriodCalculationInfo }
     *     
     */
    public ArrayOfPeriodCalculationInfo getGetAllPeriodFunctionalityWinPayListResult() {
        return getAllPeriodFunctionalityWinPayListResult;
    }

    /**
     * Sets the value of the getAllPeriodFunctionalityWinPayListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPeriodCalculationInfo }
     *     
     */
    public void setGetAllPeriodFunctionalityWinPayListResult(ArrayOfPeriodCalculationInfo value) {
        this.getAllPeriodFunctionalityWinPayListResult = value;
    }

}
