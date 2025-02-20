
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
 *         <element name="GetFunctionalityWinPayListResult" type="{http://tempuri.org/}PeriodCalculationInfo" minOccurs="0"/>
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
    "getFunctionalityWinPayListResult"
})
@XmlRootElement(name = "GetFunctionalityWinPayListResponse")
public class GetFunctionalityWinPayListResponse {

    @XmlElement(name = "GetFunctionalityWinPayListResult")
    protected PeriodCalculationInfo getFunctionalityWinPayListResult;

    /**
     * Gets the value of the getFunctionalityWinPayListResult property.
     * 
     * @return
     *     possible object is
     *     {@link PeriodCalculationInfo }
     *     
     */
    public PeriodCalculationInfo getGetFunctionalityWinPayListResult() {
        return getFunctionalityWinPayListResult;
    }

    /**
     * Sets the value of the getFunctionalityWinPayListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodCalculationInfo }
     *     
     */
    public void setGetFunctionalityWinPayListResult(PeriodCalculationInfo value) {
        this.getFunctionalityWinPayListResult = value;
    }

}
