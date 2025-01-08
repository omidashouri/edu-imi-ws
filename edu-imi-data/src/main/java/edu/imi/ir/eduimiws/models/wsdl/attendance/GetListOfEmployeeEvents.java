
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="employeeEvent" type="{http://tempuri.org/}EmployeeEventType"/&gt;
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
    "employeeEvent"
})
@XmlRootElement(name = "GetListOfEmployeeEvents")
public class GetListOfEmployeeEvents {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected EmployeeEventType employeeEvent;

    /**
     * Gets the value of the employeeEvent property.
     * 
     * @return
     *     possible object is
     *     {@link EmployeeEventType }
     *     
     */
    public EmployeeEventType getEmployeeEvent() {
        return employeeEvent;
    }

    /**
     * Sets the value of the employeeEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmployeeEventType }
     *     
     */
    public void setEmployeeEvent(EmployeeEventType value) {
        this.employeeEvent = value;
    }

}
