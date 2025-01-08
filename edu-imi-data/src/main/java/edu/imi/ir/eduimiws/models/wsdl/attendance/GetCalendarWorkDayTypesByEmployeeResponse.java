
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
 *         &lt;element name="GetCalendarWorkDayTypesByEmployeeResult" type="{http://tempuri.org/}ArrayOfCalendarDayListDto" minOccurs="0"/&gt;
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
