
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfValidEmployeeRange complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="ArrayOfValidEmployeeRange">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ValidEmployeeRange" type="{http://tempuri.org/}ValidEmployeeRange" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfValidEmployeeRange", propOrder = {
    "validEmployeeRange"
})
public class ArrayOfValidEmployeeRange {

    @XmlElement(name = "ValidEmployeeRange", nillable = true)
    protected List<ValidEmployeeRange> validEmployeeRange;

    /**
     * Gets the value of the validEmployeeRange property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the validEmployeeRange property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getValidEmployeeRange().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValidEmployeeRange }
     * </p>
     * 
     * 
     * @return
     *     The value of the validEmployeeRange property.
     */
    public List<ValidEmployeeRange> getValidEmployeeRange() {
        if (validEmployeeRange == null) {
            validEmployeeRange = new ArrayList<>();
        }
        return this.validEmployeeRange;
    }

}
