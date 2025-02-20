
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfEmployeeDataModelWithKey complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="ArrayOfEmployeeDataModelWithKey">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="EmployeeDataModelWithKey" type="{http://tempuri.org/}EmployeeDataModelWithKey" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
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
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the employeeDataModelWithKey property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getEmployeeDataModelWithKey().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EmployeeDataModelWithKey }
     * </p>
     * 
     * 
     * @return
     *     The value of the employeeDataModelWithKey property.
     */
    public List<EmployeeDataModelWithKey> getEmployeeDataModelWithKey() {
        if (employeeDataModelWithKey == null) {
            employeeDataModelWithKey = new ArrayList<>();
        }
        return this.employeeDataModelWithKey;
    }

}
