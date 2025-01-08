
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
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="withVacation" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="withSequenceWorkingDetails" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="withSpecialExtraWork" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="withVacationRemaining" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="withSpecialAddSubVacation" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="withMission" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "date",
    "withVacation",
    "withSequenceWorkingDetails",
    "withSpecialExtraWork",
    "withVacationRemaining",
    "withSpecialAddSubVacation",
    "withMission"
})
@XmlRootElement(name = "GetFunctionalityWinPayList")
public class GetFunctionalityWinPayList {

    protected String employeeCode;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    protected boolean withVacation;
    protected boolean withSequenceWorkingDetails;
    protected boolean withSpecialExtraWork;
    protected boolean withVacationRemaining;
    protected boolean withSpecialAddSubVacation;
    protected boolean withMission;

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
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the withVacation property.
     * 
     */
    public boolean isWithVacation() {
        return withVacation;
    }

    /**
     * Sets the value of the withVacation property.
     * 
     */
    public void setWithVacation(boolean value) {
        this.withVacation = value;
    }

    /**
     * Gets the value of the withSequenceWorkingDetails property.
     * 
     */
    public boolean isWithSequenceWorkingDetails() {
        return withSequenceWorkingDetails;
    }

    /**
     * Sets the value of the withSequenceWorkingDetails property.
     * 
     */
    public void setWithSequenceWorkingDetails(boolean value) {
        this.withSequenceWorkingDetails = value;
    }

    /**
     * Gets the value of the withSpecialExtraWork property.
     * 
     */
    public boolean isWithSpecialExtraWork() {
        return withSpecialExtraWork;
    }

    /**
     * Sets the value of the withSpecialExtraWork property.
     * 
     */
    public void setWithSpecialExtraWork(boolean value) {
        this.withSpecialExtraWork = value;
    }

    /**
     * Gets the value of the withVacationRemaining property.
     * 
     */
    public boolean isWithVacationRemaining() {
        return withVacationRemaining;
    }

    /**
     * Sets the value of the withVacationRemaining property.
     * 
     */
    public void setWithVacationRemaining(boolean value) {
        this.withVacationRemaining = value;
    }

    /**
     * Gets the value of the withSpecialAddSubVacation property.
     * 
     */
    public boolean isWithSpecialAddSubVacation() {
        return withSpecialAddSubVacation;
    }

    /**
     * Sets the value of the withSpecialAddSubVacation property.
     * 
     */
    public void setWithSpecialAddSubVacation(boolean value) {
        this.withSpecialAddSubVacation = value;
    }

    /**
     * Gets the value of the withMission property.
     * 
     */
    public boolean isWithMission() {
        return withMission;
    }

    /**
     * Sets the value of the withMission property.
     * 
     */
    public void setWithMission(boolean value) {
        this.withMission = value;
    }

}
