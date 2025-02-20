
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
 *         <element name="GetCalendarWorkDayTypesByEmployeeResult" type="{http://tempuri.org/}ArrayOfCalendarDayListDto" minOccurs="0"/>
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
    "getCalendarWorkDayTypesByEmployeeResult"
})
@XmlRootElement(name = "GetCalendarWorkDayTypesByEmployeeResponse")
public class GetCalendarWorkDayTypesByEmployeeResponse {

    @XmlElement(name = "GetCalendarWorkDayTypesByEmployeeResult")
    protected ArrayOfCalendarDayListDto getCalendarWorkDayTypesByEmployeeResult;

    /**
     * Gets the value of the getCalendarWorkDayTypesByEmployeeResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCalendarDayListDto }
     *     
     */
    public ArrayOfCalendarDayListDto getGetCalendarWorkDayTypesByEmployeeResult() {
        return getCalendarWorkDayTypesByEmployeeResult;
    }

    /**
     * Sets the value of the getCalendarWorkDayTypesByEmployeeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCalendarDayListDto }
     *     
     */
    public void setGetCalendarWorkDayTypesByEmployeeResult(ArrayOfCalendarDayListDto value) {
        this.getCalendarWorkDayTypesByEmployeeResult = value;
    }

}
