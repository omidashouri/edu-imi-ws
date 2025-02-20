
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
 *         <element name="GetDailyMissionsOrVacationsResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
