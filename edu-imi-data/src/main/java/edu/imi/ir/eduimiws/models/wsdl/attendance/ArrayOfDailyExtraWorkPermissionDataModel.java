
package edu.imi.ir.eduimiws.models.wsdl.attendance;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDailyExtraWorkPermissionDataModel complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="ArrayOfDailyExtraWorkPermissionDataModel">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="DailyExtraWorkPermissionDataModel" type="{http://tempuri.org/}DailyExtraWorkPermissionDataModel" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDailyExtraWorkPermissionDataModel", propOrder = {
    "dailyExtraWorkPermissionDataModel"
})
public class ArrayOfDailyExtraWorkPermissionDataModel {

    @XmlElement(name = "DailyExtraWorkPermissionDataModel", nillable = true)
    protected List<DailyExtraWorkPermissionDataModel> dailyExtraWorkPermissionDataModel;

    /**
     * Gets the value of the dailyExtraWorkPermissionDataModel property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dailyExtraWorkPermissionDataModel property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getDailyExtraWorkPermissionDataModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DailyExtraWorkPermissionDataModel }
     * </p>
     * 
     * 
     * @return
     *     The value of the dailyExtraWorkPermissionDataModel property.
     */
    public List<DailyExtraWorkPermissionDataModel> getDailyExtraWorkPermissionDataModel() {
        if (dailyExtraWorkPermissionDataModel == null) {
            dailyExtraWorkPermissionDataModel = new ArrayList<>();
        }
        return this.dailyExtraWorkPermissionDataModel;
    }

}
