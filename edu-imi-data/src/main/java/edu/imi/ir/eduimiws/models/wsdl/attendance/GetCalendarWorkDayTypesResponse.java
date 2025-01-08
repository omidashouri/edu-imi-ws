
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
 *         &lt;element name="GetCalendarWorkDayTypesResult" type="{http://tempuri.org/}ArrayOfCalendarDayListDto" minOccurs="0"/&gt;
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
