
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
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
 *         <element name="employeeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="dateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         <element name="requestState" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="leaveHour" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "employeeCode",
    "dateTime",
    "requestState",
    "leaveHour"
})
@XmlRootElement(name = "IsValidPerson")
public class IsValidPerson {

    protected String employeeCode;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTime;
    protected int requestState;
    protected String leaveHour;

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
     * Gets the value of the dateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTime(XMLGregorianCalendar value) {
        this.dateTime = value;
    }

    /**
     * Gets the value of the requestState property.
     * 
     */
    public int getRequestState() {
        return requestState;
    }

    /**
     * Sets the value of the requestState property.
     * 
     */
    public void setRequestState(int value) {
        this.requestState = value;
    }

    /**
     * Gets the value of the leaveHour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeaveHour() {
        return leaveHour;
    }

    /**
     * Sets the value of the leaveHour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeaveHour(String value) {
        this.leaveHour = value;
    }

}
