
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
 *         &lt;element name="GetAllPeriodFunctionalityWinPayListResult" type="{http://tempuri.org/}ArrayOfPeriodCalculationInfo" minOccurs="0"/&gt;
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
