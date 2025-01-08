
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
 *         &lt;element name="GetDailyMissionsOrVacationsResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "getDailyMissionsOrVacationsResult"
})
@XmlRootElement(name = "GetDailyMissionsOrVacationsResponse")
public class GetDailyMissionsOrVacationsResponse {

    @XmlElement(name = "GetDailyMissionsOrVacationsResult")
    protected String getDailyMissionsOrVacationsResult;

    /**
     * Gets the value of the getDailyMissionsOrVacationsResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetDailyMissionsOrVacationsResult() {
        return getDailyMissionsOrVacationsResult;
    }

    /**
     * Sets the value of the getDailyMissionsOrVacationsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetDailyMissionsOrVacationsResult(String value) {
        this.getDailyMissionsOrVacationsResult = value;
    }

}
