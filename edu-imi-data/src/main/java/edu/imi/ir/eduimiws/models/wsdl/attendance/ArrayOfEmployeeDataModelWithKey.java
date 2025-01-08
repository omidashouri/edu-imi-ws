
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfEmployeeDataModelWithKey complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfEmployeeDataModelWithKey"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EmployeeDataModelWithKey" type="{http://tempuri.org/}EmployeeDataModelWithKey" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfEmployeeDataModelWithKey", propOrder = {
    "employeeDataModelWithKey"
})
public class ArrayOfEmployeeDataModelWithKey {

    @XmlElement(name = "EmployeeDataModelWithKey", nillable = true)
    protected List<EmployeeDataModelWithKey> employeeDataModelWithKey;

    /**
     * Gets the value of the employeeDataModelWithKey property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the employeeDataModelWithKey property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmployeeDataModelWithKey().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EmployeeDataModelWithKey }
     * 
     * 
     */
    public List<EmployeeDataModelWithKey> getEmployeeDataModelWithKey() {
        if (employeeDataModelWithKey == null) {
            employeeDataModelWithKey = new ArrayList<EmployeeDataModelWithKey>();
        }
        return this.employeeDataModelWithKey;
    }

}
