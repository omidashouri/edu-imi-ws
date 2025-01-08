
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
 *         &lt;element name="GetFunctionalityWinPayListResult" type="{http://tempuri.org/}PeriodCalculationInfo" minOccurs="0"/&gt;
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
