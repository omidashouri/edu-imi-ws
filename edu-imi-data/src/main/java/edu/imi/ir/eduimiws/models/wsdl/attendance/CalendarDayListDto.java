
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CalendarDayListDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CalendarDayListDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CalendarId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Day" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="DayKind" type="{http://tempuri.org/}DayType"/&gt;
 *         &lt;element name="DayTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalendarDayListDto", propOrder = {
    "calendarId",
    "name",
    "day",
    "dayKind",
    "dayTypeName"
})
public class CalendarDayListDto {

    @XmlElement(name = "CalendarId")
    protected long calendarId;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Day", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar day;
    @XmlElement(name = "DayKind", required = true)
    @XmlSchemaType(name = "string")
    protected DayType dayKind;
    @XmlElement(name = "DayTypeName")
    protected String dayTypeName;

    /**
     * Gets the value of the calendarId property.
     * 
     */
    public long getCalendarId() {
        return calendarId;
    }

    /**
     * Sets the value of the calendarId property.
     * 
     */
    public void setCalendarId(long value) {
        this.calendarId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the day property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDay() {
        return day;
    }

    /**
     * Sets the value of the day property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDay(XMLGregorianCalendar value) {
        this.day = value;
    }

    /**
     * Gets the value of the dayKind property.
     * 
     * @return
     *     possible object is
     *     {@link DayType }
     *     
     */
    public DayType getDayKind() {
        return dayKind;
    }

    /**
     * Sets the value of the dayKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link DayType }
     *     
     */
    public void setDayKind(DayType value) {
        this.dayKind = value;
    }

    /**
     * Gets the value of the dayTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDayTypeName() {
        return dayTypeName;
    }

    /**
     * Sets the value of the dayTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDayTypeName(String value) {
        this.dayTypeName = value;
    }

}
