
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCalendarDayListDto complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="ArrayOfCalendarDayListDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="CalendarDayListDto" type="{http://tempuri.org/}CalendarDayListDto" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCalendarDayListDto", propOrder = {
    "calendarDayListDto"
})
public class ArrayOfCalendarDayListDto {

    @XmlElement(name = "CalendarDayListDto", nillable = true)
    protected List<CalendarDayListDto> calendarDayListDto;

    /**
     * Gets the value of the calendarDayListDto property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the calendarDayListDto property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getCalendarDayListDto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CalendarDayListDto }
     * </p>
     * 
     * 
     * @return
     *     The value of the calendarDayListDto property.
     */
    public List<CalendarDayListDto> getCalendarDayListDto() {
        if (calendarDayListDto == null) {
            calendarDayListDto = new ArrayList<>();
        }
        return this.calendarDayListDto;
    }

}
