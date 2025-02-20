
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
 *         <element name="GetTimeAttendancePcCheckByEmployeeCodeResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         <element name="reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getTimeAttendancePcCheckByEmployeeCodeResult",
    "reason"
})
@XmlRootElement(name = "GetTimeAttendancePcCheckByEmployeeCodeResponse")
public class GetTimeAttendancePcCheckByEmployeeCodeResponse {

    @XmlElement(name = "GetTimeAttendancePcCheckByEmployeeCodeResult")
    protected boolean getTimeAttendancePcCheckByEmployeeCodeResult;
    protected String reason;

    /**
     * Gets the value of the getTimeAttendancePcCheckByEmployeeCodeResult property.
     * 
     */
    public boolean isGetTimeAttendancePcCheckByEmployeeCodeResult() {
        return getTimeAttendancePcCheckByEmployeeCodeResult;
    }

    /**
     * Sets the value of the getTimeAttendancePcCheckByEmployeeCodeResult property.
     * 
     */
    public void setGetTimeAttendancePcCheckByEmployeeCodeResult(boolean value) {
        this.getTimeAttendancePcCheckByEmployeeCodeResult = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

}
