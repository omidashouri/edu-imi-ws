
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
 *         <element name="GetCalendarWorkDayTypesResult" type="{http://tempuri.org/}ArrayOfCalendarDayListDto" minOccurs="0"/>
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
    "getCalendarWorkDayTypesResult"
})
@XmlRootElement(name = "GetCalendarWorkDayTypesResponse")
public class GetCalendarWorkDayTypesResponse {

    @XmlElement(name = "GetCalendarWorkDayTypesResult")
    protected ArrayOfCalendarDayListDto getCalendarWorkDayTypesResult;

    /**
     * Gets the value of the getCalendarWorkDayTypesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCalendarDayListDto }
     *     
     */
    public ArrayOfCalendarDayListDto getGetCalendarWorkDayTypesResult() {
        return getCalendarWorkDayTypesResult;
    }

    /**
     * Sets the value of the getCalendarWorkDayTypesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCalendarDayListDto }
     *     
     */
    public void setGetCalendarWorkDayTypesResult(ArrayOfCalendarDayListDto value) {
        this.getCalendarWorkDayTypesResult = value;
    }

}
