
package edu.imi.ir.eduimiws.models.wsdl.attendance;

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
 *         <element name="employeeEvent" type="{http://tempuri.org/}EmployeeEventType"/>
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
