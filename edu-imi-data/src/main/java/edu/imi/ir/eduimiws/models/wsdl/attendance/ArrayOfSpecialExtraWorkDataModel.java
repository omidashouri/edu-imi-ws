
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSpecialExtraWorkDataModel complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="ArrayOfSpecialExtraWorkDataModel">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="SpecialExtraWorkDataModel" type="{http://tempuri.org/}SpecialExtraWorkDataModel" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSpecialExtraWorkDataModel", propOrder = {
    "specialExtraWorkDataModel"
})
public class ArrayOfSpecialExtraWorkDataModel {

    @XmlElement(name = "SpecialExtraWorkDataModel", nillable = true)
    protected List<SpecialExtraWorkDataModel> specialExtraWorkDataModel;

    /**
     * Gets the value of the specialExtraWorkDataModel property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specialExtraWorkDataModel property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getSpecialExtraWorkDataModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpecialExtraWorkDataModel }
     * </p>
     * 
     * 
     * @return
     *     The value of the specialExtraWorkDataModel property.
     */
    public List<SpecialExtraWorkDataModel> getSpecialExtraWorkDataModel() {
        if (specialExtraWorkDataModel == null) {
            specialExtraWorkDataModel = new ArrayList<>();
        }
        return this.specialExtraWorkDataModel;
    }

}
