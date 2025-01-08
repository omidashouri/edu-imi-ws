
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="employeeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="startDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="endDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="officialHolidaySetting" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="agreedHolidaySetting" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="normalDaySetting" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="chekExtraWorkPermission" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "employeeCode",
    "startDateTime",
    "endDateTime",
    "officialHolidaySetting",
    "agreedHolidaySetting",
    "normalDaySetting",
    "chekExtraWorkPermission"
})
@XmlRootElement(name = "IsValidReserve")
public class IsValidReserve {

    protected String employeeCode;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDateTime;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDateTime;
    protected String officialHolidaySetting;
    protected String agreedHolidaySetting;
    protected String normalDaySetting;
    protected boolean chekExtraWorkPermission;

    /**
     * Gets the value of the employeeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeeCode() {
        return employeeCode;
    }

    /**
     * Sets the value of the employeeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeeCode(String value) {
        this.employeeCode = value;
    }

    /**
     * Gets the value of the startDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDateTime() {
        return startDateTime;
    }

    /**
     * Sets the value of the startDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDateTime(XMLGregorianCalendar value) {
        this.startDateTime = value;
    }

    /**
     * Gets the value of the endDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDateTime() {
        return endDateTime;
    }

    /**
     * Sets the value of the endDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDateTime(XMLGregorianCalendar value) {
        this.endDateTime = value;
    }

    /**
     * Gets the value of the officialHolidaySetting property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfficialHolidaySetting() {
        return officialHolidaySetting;
    }

    /**
     * Sets the value of the officialHolidaySetting property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfficialHolidaySetting(String value) {
        this.officialHolidaySetting = value;
    }

    /**
     * Gets the value of the agreedHolidaySetting property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgreedHolidaySetting() {
        return agreedHolidaySetting;
    }

    /**
     * Sets the value of the agreedHolidaySetting property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgreedHolidaySetting(String value) {
        this.agreedHolidaySetting = value;
    }

    /**
     * Gets the value of the normalDaySetting property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNormalDaySetting() {
        return normalDaySetting;
    }

    /**
     * Sets the value of the normalDaySetting property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNormalDaySetting(String value) {
        this.normalDaySetting = value;
    }

    /**
     * Gets the value of the chekExtraWorkPermission property.
     * 
     */
    public boolean isChekExtraWorkPermission() {
        return chekExtraWorkPermission;
    }

    /**
     * Sets the value of the chekExtraWorkPermission property.
     * 
     */
    public void setChekExtraWorkPermission(boolean value) {
        this.chekExtraWorkPermission = value;
    }

}
