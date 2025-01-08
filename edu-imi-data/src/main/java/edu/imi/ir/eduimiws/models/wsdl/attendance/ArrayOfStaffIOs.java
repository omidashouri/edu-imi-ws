
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfStaffIOs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfStaffIOs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="StaffIOs" type="{http://tempuri.org/}StaffIOs" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfStaffIOs", propOrder = {
    "staffIOs"
})
public class ArrayOfStaffIOs {

    @XmlElement(name = "StaffIOs", nillable = true)
    protected List<StaffIOs> staffIOs;

    /**
     * Gets the value of the staffIOs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the staffIOs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStaffIOs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StaffIOs }
     * 
     * 
     */
    public List<StaffIOs> getStaffIOs() {
        if (staffIOs == null) {
            staffIOs = new ArrayList<StaffIOs>();
        }
        return this.staffIOs;
    }

}
